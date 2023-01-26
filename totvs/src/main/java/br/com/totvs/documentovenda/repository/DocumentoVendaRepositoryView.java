package br.com.totvs.documentovenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DocumentoVendaRepositoryView
		extends JpaRepository<DocumentoVendaView, String>, JpaSpecificationExecutor<DocumentoVendaView> {
	<T> T findById(String id, Class<T> type);
}
