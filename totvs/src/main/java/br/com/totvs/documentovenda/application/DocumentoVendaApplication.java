package br.com.totvs.documentovenda.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.documentovenda.application.command.CriarDocumentoVendaCommand;
import br.com.totvs.documentovenda.model.DocumentoVenda;
import br.com.totvs.documentovenda.model.DocumentoVendaProduto;
import br.com.totvs.documentovenda.repository.DocumentoVendaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocumentoVendaApplication {
	private final DocumentoVendaRepository repository;

	public String criar(CriarDocumentoVendaCommand criarDocumentoVendaCommand) {
		String id = UUID.randomUUID().toString();

		DocumentoVenda documentoVenda = DocumentoVenda
				.builder().id(id).clienteId(criarDocumentoVendaCommand.getClienteId()).produtos(DocumentoVendaProduto
						.builder().documentoVendaId(id).produtos(criarDocumentoVendaCommand.getProdutos()).build())
				.build();

		this.repository.save(documentoVenda);

		return documentoVenda.getId();
	}
}
