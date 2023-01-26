package br.com.totvs.documentovenda.repository;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import br.com.totvs.cliente.model.repository.ClienteView;
import br.com.totvs.produto.model.repository.ProdutoView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documento_venda")
public class DocumentoVendaView implements Serializable {
	private static final long serialVersionUID = -3781691068091960727L;

	@Id
	private String id;

	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "clienteId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	private ClienteView cliente;

	@ManyToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "produtoId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	private Set<DocumentoVendaProdutoView> produtos;
}
