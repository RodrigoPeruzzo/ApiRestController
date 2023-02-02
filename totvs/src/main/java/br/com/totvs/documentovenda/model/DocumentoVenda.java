package br.com.totvs.documentovenda.model;

import static java.util.function.Predicate.not;
import static javax.persistence.FetchType.EAGER;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = EAGER)
	@JoinColumn(name = "documentoVendaId", nullable = false, insertable = false, updatable = false)
	private Set<DocumentoVendaProduto> produtos;

	@Builder
	private DocumentoVenda(String id, String clienteId) {
		this.id = id;
		this.clienteId = clienteId;
		this.produtos = new HashSet<>();
	}

	public void patchProdutos(Set<DocumentoVendaProduto> produtos) {
		this.produtos.removeIf(not(produtos::contains));
		this.produtos.addAll(produtos);
	}
}
