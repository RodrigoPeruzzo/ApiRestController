package br.com.totvs.documentovenda.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.documentovenda.api.dtos.DocumentoVendaDTO;
import br.com.totvs.documentovenda.application.DocumentoVendaApplication;
import br.com.totvs.documentovenda.application.command.AlterarDocumentoVendaCommand;
import br.com.totvs.documentovenda.application.command.CriarDocumentoVendaCommand;
import br.com.totvs.documentovenda.repository.DocumentoVendaRepositoryView;
import br.com.totvs.documentovenda.repository.DocumentoVendaView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/documentosVenda")
public class DocumentoVendaController {
	@Autowired
	DocumentoVendaApplication documentoVendaApp;
	private final DocumentoVendaRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody DocumentoVendaDTO documentoVendaDTO) {
		CriarDocumentoVendaCommand command = CriarDocumentoVendaCommand.builder()
				.clienteId(documentoVendaDTO.getClienteId()).produtos(documentoVendaDTO.getProdutos()).build();

		return documentoVendaApp.criar(command);
	}

	@PostMapping("/{id}/alterar")
	public String alterar(@RequestBody DocumentoVendaDTO documentoVendaDTO) {
		AlterarDocumentoVendaCommand command = AlterarDocumentoVendaCommand.builder()
				.clienteId(documentoVendaDTO.getClienteId()).produtos(documentoVendaDTO.getProdutos()).build();

		return documentoVendaApp.alterar(command);
	}

	@GetMapping
	public Page<DocumentoVendaView> getAll(GetAllDocumentoVendaRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public DocumentoVendaView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, DocumentoVendaView.class)).orElseThrow();

	}

}