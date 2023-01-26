package br.com.totvs.produto.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.totvs.produto.model.enums.Tipo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
	@Id
	private String id;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	private double peso;
	
	private int vencimento;
	
	private boolean ativo;

	private String embalagemId;

	@Builder
	private Produto(String id, String descricao, Tipo tipo, double peso, int vencimento, String embalagemId) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.peso = peso;
		this.vencimento = vencimento;
		this.embalagemId = embalagemId;

		this.ativo = true;
	}

	public void ativar() {
		this.ativo = true;
	}

	public void inativar() {
		this.ativo = false;
	}

}
