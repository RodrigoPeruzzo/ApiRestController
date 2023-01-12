package br.com.totvs.cliente.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
	@Id
	private String id;
	private String nome;
	private String documento;
	private String endereco;
	private Date dataNascimento;
	private boolean ativo;

	@Builder
	private Cliente(String id, String nome, String documento, String endereco, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		
		this.ativo = true;
	}
	
	public void ativar() {
		this.ativo = true;
	}
	
	public void inativar() {
		this.ativo = false;
	}
}