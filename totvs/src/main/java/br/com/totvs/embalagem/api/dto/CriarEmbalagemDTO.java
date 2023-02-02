package br.com.totvs.embalagem.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class CriarEmbalagemDTO {
	private String descricao;
	private double altura;
	private double largura;
	private double comprimento;
}