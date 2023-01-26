package br.com.totvs.produto.application.command;

import br.com.totvs.produto.model.enums.Tipo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarProdutoCommand {
	private String id;
	private String descricao;
	private Tipo tipo;
	private double peso;
	private int vencimento;

}
