package br.com.totvs.produto.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.produto.application.command.AlterarProdutoCommand;
import br.com.totvs.produto.application.command.CriarProdutoCommand;
import br.com.totvs.produto.model.Produto;
import br.com.totvs.produto.model.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoApplication {
	private final ProdutoRepository repository;
	Set<Produto> produtos = new HashSet<>();

	public String criar(CriarProdutoCommand criarProdutoCommand) {
		Produto produto = Produto.builder().id(UUID.randomUUID().toString())
				.descricao(criarProdutoCommand.getDescricao()).tipo(criarProdutoCommand.getTipo())
				.peso(criarProdutoCommand.getPeso()).vencimento(criarProdutoCommand.getVencimento())
				.embalagemId(criarProdutoCommand.getEmbalagemId()).build();

		this.repository.save(produto);

		return produto.getId();

	}

	public void alterar(AlterarProdutoCommand alterarProdutoCommand) {
		this.repository.findById(alterarProdutoCommand.getId()).ifPresent(produto -> {
			produto.setDescricao(alterarProdutoCommand.getDescricao());
			produto.setTipo(alterarProdutoCommand.getTipo());
			produto.setPeso(alterarProdutoCommand.getPeso());
			produto.setVencimento(alterarProdutoCommand.getVencimento());
			produto.setEmbalagemId(alterarProdutoCommand.getEmbalagemId());

			this.repository.save(produto);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(produto -> {
			produto.ativar();

			this.repository.save(produto);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(produto -> {
			produto.inativar();

			this.repository.save(produto);
		});
	}
}
