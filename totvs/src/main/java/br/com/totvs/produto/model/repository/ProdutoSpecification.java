package br.com.totvs.produto.model.repository;

import java.util.function.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoSpecification {
	public static Specification<ProdutoView> queConteinhaDescricaoCom(String descricao){
		
		return new Specification<ProdutoView>() {
			
			private static final long serialVersionUID = 5642778713948387463L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("descricao")), likeTerm(descricao.trim().toUpperCase()));
				
			}
		};		
	}
	
	public static Specification<ProdutoView> queContenhaAlturaCom(double altura){
		return ner Specification<ProdutoView>(){
			private
			
		}
		
	}
	
	

}
