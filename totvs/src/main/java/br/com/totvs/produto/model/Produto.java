package br.com.totvs.produto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.totvs.embalagem.model.Embalagem;
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
	private Tipo tipo;
	private double peso;
	private int vencimento;
	private boolean ativo;
	
	private Embalagem embalagem;

	@Builder
	private Produto(String id, String descricao, Tipo tipo, double peso, int vencimento) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.peso = peso;
		this.vencimento = vencimento;

		this.ativo = true;
	}

	public void ativar() {
		this.ativo = true;
	}

	public void inativar() {
		this.ativo = false;
	}

}
