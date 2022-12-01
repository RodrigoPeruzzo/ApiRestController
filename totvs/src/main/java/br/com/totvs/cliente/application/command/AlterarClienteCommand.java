package br.com.totvs.cliente.application.command;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarClienteCommand {
	private String id;
	private String nome;
	private String endereco;
	private Date dataNascimento;
}