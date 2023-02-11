package br.com.totvs.documentovenda.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.documentovenda.model.DocumentoVenda;

@Transactional
public interface DocumentoVendaRepository extends JpaRepository<DocumentoVenda, String> {
	<T> T findById(String id, Class<T> type);

}
