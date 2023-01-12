package br.com.totvs.cliente.api;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.cliente.model.repository.ClienteSpecification;
import br.com.totvs.cliente.model.repository.ClienteView;
import lombok.Data;

@Data
public class GetAllClienteRequest {
	private String nome;
	private String documento;
	private String endereco;
	private String searchTerm;

	public Specification<ClienteView> buildSpecification() {
		Specification<ClienteView> specs = Specification.where(null);

		if (hasText(this.searchTerm)) {
			specs = specs.or(ClienteSpecification.queContenhaNomeCom(this.searchTerm));
			specs = specs.or(ClienteSpecification.queContenhaDocumentoCom(this.searchTerm));
			specs = specs.or(ClienteSpecification.queContenhaEnderecoCom(this.searchTerm));
		} else {
			if (hasText(this.nome))
				specs = specs.and(ClienteSpecification.queContenhaNomeCom(this.nome));

			if (hasText(this.documento))
				specs = specs.and(ClienteSpecification.queContenhaDocumentoCom(this.documento));

			if (hasText(this.endereco))
				specs = specs.and(ClienteSpecification.queContenhaEnderecoCom(this.endereco));
		}

		return specs;
	}
}