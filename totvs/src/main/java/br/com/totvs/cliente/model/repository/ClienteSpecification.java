package br.com.totvs.cliente.model.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteSpecification {
	public static Specification<ClienteView> queContenhaNomeCom(String nome) {
		return new Specification<ClienteView>() {
			private static final long serialVersionUID = 4451395911759887462L;

			public Predicate toPredicate(Root<ClienteView> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(builder.upper(root.get("nome")), likeTerm(nome.trim().toUpperCase()));
			}
		};
	}

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
