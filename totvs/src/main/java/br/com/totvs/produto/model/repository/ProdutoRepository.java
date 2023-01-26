package br.com.totvs.produto.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.totvs.produto.model.Produto;

@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, String> {
	<T> T findById(String id, Class<T> type);

}
