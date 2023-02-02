package br.com.totvs.documentovenda.application.command;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarDocumentoVendaCommand {
	private String clienteId;
	private Set<String> produtos;

}
