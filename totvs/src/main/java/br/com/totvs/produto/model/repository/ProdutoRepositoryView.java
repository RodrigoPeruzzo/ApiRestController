package br.com.totvs.produto.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProdutoRepositoryView
		extends JpaRepository<ProdutoView, String>, JpaSpecificationExecutor<ProdutoView> {
	<T> T findById(String id, Class<T> type);
}
