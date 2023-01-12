package br.com.totvs.cliente.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryView
		extends JpaRepository<ClienteView, String>, JpaSpecificationExecutor<ClienteView> {
	<T> T findById(String id, Class<T> type);
}