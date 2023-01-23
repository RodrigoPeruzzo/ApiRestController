package br.com.totvs.produto.api;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.produto.api.dto.AlterarProdutoDTO;
import br.com.totvs.produto.api.dto.CriarProdutoDTO;
import br.com.totvs.produto.application.ProdutoApplication;
import br.com.totvs.produto.application.command.AlterarProdutoCommand;
import br.com.totvs.produto.application.command.CriarProdutoCommand;
import br.com.totvs.produto.model.repository.ProdutoRepositoryView;
import br.com.totvs.produto.model.repository.ProdutoView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

	@Autowired
	ProdutoApplication produtoApp;
	private final ProdutoRepositoryView repositoryview;

	@PostMapping
	public String criar(@RequestBody CriarProdutoDTO produtoDTO) {
		CriarProdutoCommand command = CriarProdutoCommand.builder().descricao(produtoDTO.getDescricao())
				.tipo(produtoDTO.getTipo()).peso(produtoDTO.getPeso()).vencimento(produtoDTO.getVencimento()).build();

		return produtoApp.criar(command);

	}

	@PostMapping(path = "/{id}/alterar")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarProdutoDTO produtoDTO) {
		AlterarProdutoCommand command = AlterarProdutoCommand.builder().id(id).descricao(produtoDTO.getDescricao())
				.tipo(produtoDTO.getTipo()).peso(produtoDTO.getPeso()).vencimento(produtoDTO.getVencimento()).build();

		produtoApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		produtoApp.inativar(id);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<ProdutoView> getAll(GetAllProdutoRequest filterRequest, Pageable pageable) {

		return this.repositoryview.findAll(filterRequest.buildSpecification(), pageable);
	}

	@GetMapping(path = "{id}")
	public ProdutoView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryview.findById(id, ProdutoView.class)).orElseThrow();

	}

}
