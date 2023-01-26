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

	public static Specification<ProdutoView> queContenhaTipoCom(String tipo) {
		return new Specification<ProdutoView>() {

			private static final long serialVersionUID = 7175920697682698943L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("tipo"), tipo);
			}
		};
	}

	public static Specification<ProdutoView> queContenhaPesoCom(String peso) {
		return new Specification<ProdutoView>() {

			private static final long serialVersionUID = 1654654864778648694L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("peso"), peso);
			}
		};
	}

	public static Specification<ProdutoView> queContenhaVencimentoCom(String vencimento) {
		return new Specification<ProdutoView>() {

			private static final long serialVersionUID = 6498789494494193215L;

			public Predicate toPredicate(Root<ProdutoView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("vencimento"), vencimento);

			}
		};
	}

	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();
	}

}
