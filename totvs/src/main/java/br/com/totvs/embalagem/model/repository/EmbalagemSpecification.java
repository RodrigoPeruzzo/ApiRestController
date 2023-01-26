package br.com.totvs.embalagem.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmbalagemSpecification {
	public static Specification<EmbalagemView> queContenhaDescricaoCom(String descricao) {
		return new Specification<EmbalagemView>() {

			private static final long serialVersionUID = -524071530098183050L;

			public Predicate toPredicate(Root<EmbalagemView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("descricao")), likeTerm(descricao.trim().toUpperCase()));
			}
		};
	}

	public static Specification<EmbalagemView> queContenhaAlturaCom(String altura) {
		return new Specification<EmbalagemView>() {

			private static final long serialVersionUID = 5973145312862851256L;

			public Predicate toPredicate(Root<EmbalagemView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("altura"), altura);
			}
		};
	}

	public static Specification<EmbalagemView> queContenhaLarguraCom(String largura) {
		return new Specification<EmbalagemView>() {
			private static final long serialVersionUID = 51468465163518651L;

			public Predicate toPredicate(Root<EmbalagemView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("lagura"), largura);
			}
		};
	}

	public static Specification<EmbalagemView> queContenhaComprimentoCom(String comprimento) {
		return new Specification<EmbalagemView>() {
			private static final long serialVersionUID = 269941548916521L;

			public Predicate toPredicate(Root<EmbalagemView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.equal(root.get("comprimento"), comprimento);
			}
		};
	}

	private static String likeTerm(String term) {
		return new StringBuilder().append('%').append(term).append('%').toString();

	}
}
