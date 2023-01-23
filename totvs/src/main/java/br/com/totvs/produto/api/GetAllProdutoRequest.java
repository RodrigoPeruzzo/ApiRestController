package br.com.totvs.produto.api;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.cliente.model.repository.ClienteView;
import br.com.totvs.produto.model.repository.ProdutoSpecification;
import br.com.totvs.produto.model.repository.ProdutoView;
import lombok.Data;

@Data
public class GetAllProdutoRequest {
	
	private String descricao;
	private Enum tipo;
	private double peso;
	private int vencimento;
	private String searchTerm;
	
	public Specification<ProdutoView> buildSpecification(){
		
		Specification<ClienteView> specs = Specification.where(null);
		
		if(hasText(this.searchTerm)){
			specs = specs.or(ProdutoSpecification.queContenhaDescricaoCom(this.searchTerm));
			specs = specs.or(ProdutoSpecification.queContenhaTipoCom(this.searchTerm));
			specs = specs.or(ProdutoSpecification.queContenhaPesoCom(this.searchTerm));
			specs = specs.or(ProdutoSpecification.queContenhaVencimentoCom(this.searchTerm));		
		} else {
			if(hasText(this.descricao))
				specs = specs.and(ProdutoSpecification.queContenhaDescricaoCom(this.descricao));
			
			if(hasText(this.tipo))
				specs = specs.and(ProdutoSpecification.queContenhaTipoCom(this.tipo));
			
			if(hasText(this.peso))
				specs = specs.and(ProdutoSpecification.queContenhaPesoCom(this.peso));
			
			if(hasText(this.vencimento))
				specs = specs.and(ProdutoSpecification.queContenhaVencimento(this.vencimento));
			
		}
		
		return specs;			
	
		}	
		
	}
	
	
	
	
	
	


