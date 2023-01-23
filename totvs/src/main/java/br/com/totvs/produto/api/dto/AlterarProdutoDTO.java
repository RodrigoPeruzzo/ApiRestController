package br.com.totvs.produto.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class AlterarProdutoDTO {
	
	private String descricao;
	private Enum tipo;
	private double peso;
	private int vencimento;

}
