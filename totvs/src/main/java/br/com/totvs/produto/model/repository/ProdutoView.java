package br.com.totvs.produto.model.repository;

import java.io.Serializable;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import br.com.totvs.embalagem.model.repository.EmbalagemView;
import br.com.totvs.produto.model.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class ProdutoView implements Serializable {
	private static final long serialVersionUID = -9181759408874227665L;

	@Id
	private String id;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	private double peso;
	
	private int vencimento;
	
	private boolean ativo;

	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "embalagemId", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	EmbalagemView embalagem;
}
