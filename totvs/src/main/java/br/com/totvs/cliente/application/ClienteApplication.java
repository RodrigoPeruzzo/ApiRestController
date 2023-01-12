package br.com.totvs.cliente.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.cliente.application.command.AlterarClienteCommand;
import br.com.totvs.cliente.application.command.CriarClienteCommand;
import br.com.totvs.cliente.model.Cliente;
import br.com.totvs.cliente.model.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteApplication {
	private final ClienteRepository repository;

	Set<Cliente> clientes = new HashSet<>();

	public String criar(CriarClienteCommand criarClienteCommand) {
		Cliente cliente = Cliente.builder().id(UUID.randomUUID().toString()).nome(criarClienteCommand.getNome())
				.documento(criarClienteCommand.getDocumento()).endereco(criarClienteCommand.getEndereco())
				.dataNascimento(criarClienteCommand.getDataNascimento()).build();

		this.repository.save(cliente);

		return cliente.getId();
	}

	public void alterar(AlterarClienteCommand alterarClienteCommand) {
		this.repository.findById(alterarClienteCommand.getId()).ifPresent(cliente -> {
			cliente.setNome(alterarClienteCommand.getNome());
			cliente.setEndereco(alterarClienteCommand.getEndereco());
			cliente.setDataNascimento(alterarClienteCommand.getDataNascimento());

			this.repository.save(cliente);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(cliente -> {
			cliente.ativar();

			this.repository.save(cliente);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(cliente -> {
			cliente.inativar();

			this.repository.save(cliente);
		});
	}
}