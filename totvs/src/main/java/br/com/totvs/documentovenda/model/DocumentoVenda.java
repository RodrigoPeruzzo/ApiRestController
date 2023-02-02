package br.com.totvs.documentovenda.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "documento_venda")
public class DocumentoVenda {
	@Id
	private String id;

	private String clienteId;

	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "documentoVendaId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	private Set<DocumentoVendaProduto> produtos = new HashSet<>();

	@Builder
	private DocumentoVenda(String id, String clienteId, Set<DocumentoVendaProduto> produtos) {
		this.id = id;
		this.clienteId = clienteId;
		this.produtos = produtos;
	}
}
