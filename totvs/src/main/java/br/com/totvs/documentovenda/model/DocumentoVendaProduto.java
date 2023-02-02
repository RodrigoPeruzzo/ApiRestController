package br.com.totvs.documentovenda.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@IdClass(DocumentoVendaProdutoId.class)
@Table(name = "documento_venda_produto")
public class DocumentoVendaProduto {
	@Id
	private String documentoVendaId;

	@Id
	private String id;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoVendaProduto other = (DocumentoVendaProduto) obj;
		return Objects.equals(id, other.id) && Objects.equals(documentoVendaId, other.documentoVendaId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, documentoVendaId);
	}
}
