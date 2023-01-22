package br.com.totvs.embalagem.application.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarEmbalagemCommand {
	private String descricao;
	private double altura;
	private double largura;
	private double comprimento;
}
