package br.com.totvs.documentovenda.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;

@Builder
@Entity
@Table(name = "documento_venda_produto")
public class DocumentoVendaProduto {
	private String documentoVendaId;

	private Set<String> produtos;
}
