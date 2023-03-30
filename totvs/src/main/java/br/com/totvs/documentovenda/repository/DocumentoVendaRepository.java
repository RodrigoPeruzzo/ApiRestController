package br.com.totvs.documentovenda.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.totvs.documentovenda.model.DocumentoVenda;

@Repository
@Transactional
public interface DocumentoVendaRepository extends JpaRepository<DocumentoVenda, String> {
	<T> T findById(String id, Class<T> type);

}
