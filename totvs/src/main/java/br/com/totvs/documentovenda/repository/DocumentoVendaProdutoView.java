package br.com.totvs.documentovenda.repository;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import br.com.totvs.documentovenda.model.DocumentoVendaProdutoId;
import br.com.totvs.produto.model.repository.ProdutoView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@IdClass(DocumentoVendaProdutoId.class)
@Table(name = "documento_venda_produto")
public class DocumentoVendaProdutoView {
	@Id
	@JsonIgnore
	private String produtoId;

	@Id
	@JsonIgnore
	private String documentoVendaId;

	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "produtoId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	@JsonUnwrapped
	private ProdutoView produto;
}