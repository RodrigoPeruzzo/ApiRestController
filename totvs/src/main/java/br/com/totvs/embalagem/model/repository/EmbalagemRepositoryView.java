package br.com.totvs.embalagem.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmbalagemRepositoryView
		extends JpaRepository<EmbalagemView, String>, JpaSpecificationExecutor<EmbalagemView> {
	<T> T findById(String id, Class<T> type);

}
