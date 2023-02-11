package br.com.totvs.embalagem.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.embalagem.model.repository.EmbalagemSpecification;
import br.com.totvs.embalagem.model.repository.EmbalagemView;

public class GetAllEmbalagemRequest {

	private String descricao;
	private String altura;
	private String largura;
	private String comprimento;
	private String searchTerm;

	public Specification<EmbalagemView> buildSpecification() {
		Specification<EmbalagemView> specs = Specification.where(null);
		if (hasText(this.searchTerm)) {
			specs = specs.or(EmbalagemSpecification.queContenhaDescricaoCom(this.searchTerm));
			specs = specs.or(EmbalagemSpecification.queContenhaAlturaCom(this.searchTerm));
			specs = specs.or(EmbalagemSpecification.queContenhaLarguraCom(this.searchTerm));
			specs = specs.or(EmbalagemSpecification.queContenhaComprimentoCom(this.searchTerm));
		} else {
			if (hasText(this.descricao))
				specs = specs.and(EmbalagemSpecification.queContenhaDescricaoCom(this.descricao));
			if (hasText(this.altura))
				specs = specs.and(EmbalagemSpecification.queContenhaAlturaCom(this.altura));
			if (hasText(this.largura))
				specs = specs.and(EmbalagemSpecification.queContenhaLarguraCom(this.largura));
			if (hasText(this.comprimento))
				specs = specs.and(EmbalagemSpecification.queContenhaComprimentoCom(this.comprimento));
		}
		return specs;
	}
}
