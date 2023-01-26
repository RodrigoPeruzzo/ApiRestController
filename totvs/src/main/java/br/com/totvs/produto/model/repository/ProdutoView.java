package br.com.totvs.produto.model.repository;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")

public class ProdutoView implements Serializable {

	private static final long serialVersionUID = -3894603045522590281L;
	@Id
	private String id;
	private String descricao;
	private double altura;
	private double largura;
	private double comprimento;

}
