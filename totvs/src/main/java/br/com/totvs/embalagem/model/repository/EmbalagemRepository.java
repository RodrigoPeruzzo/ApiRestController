package br.com.totvs.embalagem.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.totvs.embalagem.model.Embalagem;

@Repository
@Transactional
public interface EmbalagemRepository extends JpaRepository<Embalagem, String> {
	<T> T findById(String id, Class<T> type);

}
