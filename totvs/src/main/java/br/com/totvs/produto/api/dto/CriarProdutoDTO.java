package br.com.totvs.produto.api.dto;

import br.com.totvs.produto.model.enums.Tipo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class CriarProdutoDTO {
	private String descricao;
	private Tipo tipo;
	private double peso;
	private int vencimento;

}
