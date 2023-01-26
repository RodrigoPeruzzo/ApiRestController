package br.com.totvs.embalagem.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.embalagem.model.Embalagem;

@Transactional
public interface EmbalagemRepository extends JpaRepository<Embalagem, String> {
	<T> T findById(String id, Class<T> type);

}
