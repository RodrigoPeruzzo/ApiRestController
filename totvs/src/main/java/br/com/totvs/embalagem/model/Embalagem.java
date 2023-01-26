package br.com.totvs.embalagem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "embalagem")
public class Embalagem {
	@Id
	private String id;
	private String descricao;
	private double altura;
	private double largura;
	private double comprimento;
	private boolean ativo;

	@Builder
	private Embalagem(String id, String descricao, double altura, double largura, double comprimento) {
		this.id = id;
		this.descricao = descricao;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.ativo = true;
	}

	public void ativar() {
		this.ativo = true;
	}

	public void inativar() {

		this.ativo = false;
	}
}
