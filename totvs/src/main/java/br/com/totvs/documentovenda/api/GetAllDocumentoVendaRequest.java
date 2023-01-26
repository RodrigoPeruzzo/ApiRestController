package br.com.totvs.documentovenda.api;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.documentovenda.repository.DocumentoVendaView;
import lombok.Data;

@Data
public class GetAllDocumentoVendaRequest {
	private String searchTerm;

	public Specification<DocumentoVendaView> buildSpecification() {
		Specification<DocumentoVendaView> specs = Specification.where(null);

		return specs;
	}
}
