package br.com.totvs.cliente.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Cliente {
	private String id;
	private String nome;
	private String documento;
	private String endereco;
	private Date dataNascimento;

	@Builder
	private Cliente(String id, String nome, String documento, String endereco, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}
}