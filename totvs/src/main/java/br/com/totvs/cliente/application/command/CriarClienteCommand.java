package br.com.totvs.cliente.application.command;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarClienteCommand {
	private String nome;
	private String documento;
	private String endereco;
	private Date dataNascimento;
}
