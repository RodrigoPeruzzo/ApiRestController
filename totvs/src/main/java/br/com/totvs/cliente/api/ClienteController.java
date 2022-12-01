package br.com.totvs.cliente.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.cliente.api.dto.CriarClienteDTO;
import br.com.totvs.cliente.application.ClienteApplication;
import br.com.totvs.cliente.application.command.CriarClienteCommand;

@RestController
@RequestMapping(path = "/api/v1")
public class ClienteController {

	@Autowired
	ClienteApplication clienteApp;

	@PostMapping
	public String criar(@RequestBody CriarClienteDTO clienteDTO) {
		CriarClienteCommand command = CriarClienteCommand.builder().nome(clienteDTO.getNome())
				.documento(clienteDTO.getNome()).endereco(clienteDTO.getEndereco())
				.dataNascimento(clienteDTO.getDataNascimento()).build();

		return clienteApp.criar(command);
	}
}
