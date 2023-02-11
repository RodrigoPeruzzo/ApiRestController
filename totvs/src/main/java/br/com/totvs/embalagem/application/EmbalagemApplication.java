package br.com.totvs.embalagem.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.embalagem.application.command.AlterarEmbalagemCommand;
import br.com.totvs.embalagem.application.command.CriarEmbalagemCommand;
import br.com.totvs.embalagem.model.Embalagem;
import br.com.totvs.embalagem.model.repository.EmbalagemRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmbalagemApplication {
	private final EmbalagemRepository repository;
	Set<Embalagem> embalagens = new HashSet<>();

	public String criar(CriarEmbalagemCommand criarEmbalagemCommand) {

		Embalagem embalagem = Embalagem.builder().id(UUID.randomUUID().toString())
				.descricao(criarEmbalagemCommand.getDescricao()).altura(criarEmbalagemCommand.getAltura())
				.largura(criarEmbalagemCommand.getLargura()).comprimento(criarEmbalagemCommand.getComprimento())
				.build();

		this.repository.save(embalagem);

		return embalagem.getId();
	}

	public void alterar(AlterarEmbalagemCommand alterarEmbalagemCommand) {
		this.repository.findById(alterarEmbalagemCommand.getId()).ifPresent(embalagem -> {
			embalagem.setDescricao(alterarEmbalagemCommand.getDescricao());
			embalagem.setAltura(alterarEmbalagemCommand.getAltura());
			embalagem.setLargura(alterarEmbalagemCommand.getLargura());
			embalagem.setComprimento(alterarEmbalagemCommand.getComprimento());

			this.repository.save(embalagem);

		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(embalagem -> {
			embalagem.ativar();

			this.repository.save(embalagem);

		});

	}

	public void inativar(String id) {

		this.repository.findById(id).ifPresent(embalagem -> {
			embalagem.inativar();

			this.repository.save(embalagem);

		});

	}

}
