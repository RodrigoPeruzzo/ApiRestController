package br.com.totvs.produto.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.produto.model.enums.Tipo;
import br.com.totvs.produto.model.repository.ProdutoSpecification;
import br.com.totvs.produto.model.repository.ProdutoView;
import lombok.Data;

@Data
public class GetAllProdutoRequest {

	private String descricao;
	private Tipo tipo;
	private String peso;
	private String vencimento;
	private String searchTerm;

	public Specification<ProdutoView> buildSpecification() {
		Specification<ProdutoView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(ProdutoSpecification.queContenhaDescricaoCom(this.searchTerm));
			specs = specs.or(ProdutoSpecification.queContenhaTipoCom(this.searchTerm));
			specs = specs.or(ProdutoSpecification.queContenhaPesoCom(this.searchTerm));
			specs = specs.or(ProdutoSpecification.queContenhaVencimentoCom(this.searchTerm));
		} else {
			if (hasText(this.descricao))
				specs = specs.and(ProdutoSpecification.queContenhaDescricaoCom(this.descricao.toString()));

			if (this.tipo != null)
				specs = specs.and(ProdutoSpecification.queContenhaTipoCom(this.tipo.toString()));

			if (hasText(this.peso))
				specs = specs.and(ProdutoSpecification.queContenhaPesoCom(this.peso.toString()));

			if (hasText(this.vencimento))
				specs = specs.and(ProdutoSpecification.queContenhaVencimentoCom(this.vencimento.toString()));
		}
		return specs;
	}
}
