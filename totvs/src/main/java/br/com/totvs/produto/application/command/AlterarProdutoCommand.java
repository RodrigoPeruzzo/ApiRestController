package br.com.totvs.produto.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarProdutoCommand {
	private String id;
	private String descricao;
	private Enum tipo;
	private double peso;
	private int vencimento;

}
