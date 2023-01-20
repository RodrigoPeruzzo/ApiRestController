package br.com.totvs.embalagem.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.embalagem.api.dto.AlterarEmbalagemDTO;
import br.com.totvs.embalagem.api.dto.CriarEmbalagemDTO;
import br.com.totvs.embalagem.application.EmbalagemApplication;
import br.com.totvs.embalagem.application.command.AlterarEmbalagemCommand;
import br.com.totvs.embalagem.application.command.CriarEmbalagemCommand;
import br.com.totvs.embalagem.model.repository.EmbalagemRepositoryView;
import br.com.totvs.embalagem.model.repository.EmbalagemView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/embalagens")
public class EmbalagemController {

	@Autowired
	EmbalagemApplication embalagemApp;

	private final EmbalagemRepositoryView repositoryView;

	@PostMapping
	public String criar(@RequestBody CriarEmbalagemDTO embalagemDTO) {
		CriarEmbalagemCommand command = CriarEmbalagemCommand.builder().descricao(embalagemDTO.getDescricao())
				.altura(embalagemDTO.getAltura()).largura(embalagemDTO.getLargura())
				.comprimento(embalagemDTO.getComprimento()).build;
		return embalagemApp.criar(command);
	}

	@PostMapping(path = "/{id}/alterar")
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody AlterarEmbalagemDTO embalagemDTO) {
		AlterarEmbalagemCommand command = AlterarEmbalagemCommand.builder().id(id)
				.descricao(embalagemDTO.getDescricao()).altura(embalagemDTO.getAltura())
				.largura(embalagemDTO.getLargura()).comprimento(embalagemDTO.getComprimento()).build;

		embalagemApp.alterar(command);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/ativar")
	public ResponseEntity<Void> ativar(@PathVariable String id) {
		embalagemApp.ativar(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/{id}/inativar")
	public ResponseEntity<Void> inativar(@PathVariable String id) {
		embalagemApp.inativar(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public Page<EmbalagemView> getAll(GetAllEmbalagemRequest filterRequest, Pageable pageable) {
		return this.repositoryView.findAll(filterRequest.buildSpecification(), pageable);

	}

	@GetMapping(path = "/{id}")
	public EmbalagemView getById(@PathVariable String id) {
		return Optional.ofNullable(this.repositoryView.findById(id, EmbalagemView.class)).orElseThrow();

	}

}
