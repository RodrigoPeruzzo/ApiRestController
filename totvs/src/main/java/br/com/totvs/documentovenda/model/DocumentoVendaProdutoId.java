package br.com.totvs.documentovenda.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DocumentoVendaProdutoId implements Serializable {
	private static final long serialVersionUID = 8341700864314305320L;

	private String id;

	private String documentoVendaId;
}