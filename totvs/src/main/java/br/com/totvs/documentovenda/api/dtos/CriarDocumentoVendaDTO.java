package br.com.totvs.documentovenda.api.dtos;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CriarDocumentoVendaDTO {
	private String clienteId;
	private Set<String> produtos;
}