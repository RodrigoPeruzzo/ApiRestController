package br.com.totvs.cliente.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.totvs.cliente.model.Cliente;


@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	<T> T findById(String id, Class<T> type);
}