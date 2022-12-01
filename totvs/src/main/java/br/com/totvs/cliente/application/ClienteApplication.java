package br.com.totvs.cliente.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.cliente.application.command.AlterarClienteCommand;
import br.com.totvs.cliente.application.command.CriarClienteCommand;
import br.com.totvs.cliente.model.Cliente;
import br.com.totvs.cliente.model.Cliente.ClienteBuilder;

@Service
public class ClienteApplication {
	Set<Cliente> clientes = new HashSet<>();

	public String criar(CriarClienteCommand criarClienteCommand) {
		Cliente cliente = Cliente.builder().id(UUID.randomUUID().toString()).nome(criarClienteCommand.getNome())
				.documento(criarClienteCommand.getDocumento()).endereco(criarClienteCommand.getEndereco())
				.dataNascimento(criarClienteCommand.getDataNascimento()).build();

		clientes.add(cliente);
		
		return cliente.getId();
	}

	public void alterar(AlterarClienteCommand alterarClienteCommand) {
		ClienteBuilder cliente = Cliente.builder().id(alterarClienteCommand.getId())
				.nome(alterarClienteCommand.getNome()).endereco(alterarClienteCommand.getEndereco())
				.dataNascimento(alterarClienteCommand.getDataNascimento());

		Set<Cliente> clientesAlterados = new HashSet<>();

		clientes.stream().filter(filtro -> !filtro.getId().equals(alterarClienteCommand.getId()))
				.forEach(clienteFiltrado -> {
					clientesAlterados.add(clienteFiltrado);
				});

		Cliente clienteAnterior = clientes.stream()
				.filter(filtro -> filtro.getId().equals(alterarClienteCommand.getId())).findFirst().get();

		clientesAlterados.add(cliente.documento(clienteAnterior.getDocumento()).build());
	}

	public void excluir(String id) {
		Set<Cliente> clientesAlterados = new HashSet<>();

		clientes.stream().filter(filtro -> !filtro.getId().equals(id)).forEach(clienteFiltrado -> {
			clientesAlterados.add(clienteFiltrado);
		});
	}

	public void ativar(String id) {

	}

	public void inativar(String id) {

	}

}
