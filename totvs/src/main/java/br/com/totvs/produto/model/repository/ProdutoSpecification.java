package br.com.totvs.produto.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoSpecification {
	public static Specification<ProdutoView> queContenhaDescricaoCom(String descricao) {
		return new Specification<ProdutoView>() {
			private static final long serialVersionUID = 5642778713948387463L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("descricao")), likeTerm(descricao.trim().toUpperCase()));
			}
		};
	}

	public static Specification<ProdutoView> queContenhaAlturaCom(double altura) {
		return new Specification<ProdutoView>() {

			private static final long serialVersionUID = 7175920697682698943L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("altura"), altura);
			}
		};
	}

	public static Specification<ProdutoView> queContenhaLarguraCom(double largura) {
		return new Specification<ProdutoView>() {

			private static final long serialVersionUID = 1654654864778648694L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("largura"),largura);
			}
		};
	}

	public static Specification<ProdutoView> queContenhaComprimentoCom(double comprimento) {
		return new Specification<ProdutoView>() {

			private static final long serialVersionUID = 6498789494494193215L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("comprimento"), comprimento);

			}
		};
	}

	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}


}
