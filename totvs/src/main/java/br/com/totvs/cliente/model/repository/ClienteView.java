package br.com.totvs.cliente.model.repository;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class ClienteView implements Serializable {
	private static final long serialVersionUID = 5009977676434422060L;

	@Id
	private String id;

	private String nome;
	private String documento;
	private String endereco;
	private Date dataNascimento;
}