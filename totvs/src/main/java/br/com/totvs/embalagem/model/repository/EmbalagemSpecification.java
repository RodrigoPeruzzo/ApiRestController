package br.com.totvs.embalagem.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.totvs.cliente.model.repository.ClienteView;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AcessLevel.PRIVATE)
public class EmbalagemSpecification {
	public static Specification<EmbalagemView> queContenhaDescricaoCom(String descricao){
		return new Specification<EmbalagemView>() {
			private static final long serialVersionUID = ;
			
			public Predicate toPredicate(Root<EmbalagemView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder,like(builder.upper(root.get("descricao")), likeTerm(descricao.trim().toUpperCase()));
				
			}		
		};
		
		
		// ---------------------------COPIEI DO CLIENTE, ALTERAR------------------------------------------------------------
		public static Specification<ClienteView> queContenhaDocumentoCom(String documento) {
			return new Specification<ClienteView>() {
				private static final long serialVersionUID = 1328568327463966463L;

				public Predicate toPredicate(Root<ClienteView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
					return builder.like(builder.upper(root.get("documento")), likeTerm(documento.trim().toUpperCase()));
				}
			};
		}
		
		
		

		public static Specification<ClienteView> queContenhaEnderecoCom(String endereco) {
			return new Specification<ClienteView>() {
				private static final long serialVersionUID = -2810378777392539835L;

				public Predicate toPredicate(Root<ClienteView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
					return builder.like(builder.upper(root.get("endereco")), likeTerm(endereco.trim().toUpperCase()));
				}
			};
		}

		private static String likeTerm(String term) {
			return new StringBuilder().append('%').append(term).append('%').toString();
		}
		
	
	}

}
