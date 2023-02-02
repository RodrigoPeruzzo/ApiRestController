package br.com.totvs.documentovenda.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DocumentoVendaProdutoId implements Serializable {
	private static final long serialVersionUID = -7630581546603580978L;

	private String produtoId;

	private String documentoVendaId;
}