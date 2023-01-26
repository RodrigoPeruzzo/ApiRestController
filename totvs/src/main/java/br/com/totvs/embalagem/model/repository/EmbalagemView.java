package br.com.totvs.embalagem.model.repository;

import java.io.Serializable;

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
@Table(name = "embalagem")
public class EmbalagemView  implements Serializable{
	
	
	private static final long serialVersionUID = 1784641278497845768L;

	@Id
	private String id;
	
	private String descricao;
	private double altura;
	private double largura;
	private double comprimento;
	

}
