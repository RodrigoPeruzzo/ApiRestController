package br.com.totvs.cliente.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.cliente.api.dto.AlterarClienteDTO;
import br.com.totvs.cliente.api.dto.CriarClienteDTO;
import br.com.totvs.cliente.application.ClienteApplication;
import br.com.totvs.cliente.application.command.AlterarClienteCommand;
import br.com.totvs.cliente.application.command.CriarClienteCommand;
import br.com.totvs.cliente.model.repository.ClienteRepositoryView;
import br.com.totvs.cliente.model.repository.ClienteView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteController {

	@Autowired
	ClienteApplication clienteApp;

	private final ClienteRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarClienteDTO clienteDTO) {
		CriarClienteCommand command = CriarClienteCommand.builder().nome(clienteDTO.getNome())
				.documento(clienteDTO.getDocumento()).endereco(clienteDTO.getEndereco())
				.dataNascimento(clienteDTO.getDataNascimento()).build();

		return clienteApp.criar(command);
	}

	@PostMapping(path = "/{id}/alterar")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarClienteDTO clienteDTO) {
		AlterarClienteCommand command = AlterarClienteCommand.builder().id(id).nome(clienteDTO.getNome())
				.endereco(clienteDTO.getEndereco()).dataNascimento(clienteDTO.getDataNascimento()).build();

		clienteApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		clienteApp.ativar(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		clienteApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<ClienteView> getAll(GetAllClienteRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "/{id}")
	public ClienteView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, ClienteView.class)).orElseThrow();
	}
}
