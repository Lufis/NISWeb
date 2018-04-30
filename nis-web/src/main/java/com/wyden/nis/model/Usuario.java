package com.wyden.nis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.wyden.nis.core.model.commons.converter.BooleanConverter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SEG_USUARIO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7184637490708124592L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USU_ID_USUARIO")
	private Long id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "USU_DS_LOGIN")
	private String login;
	
	@NotBlank
	@Size(max = 250)
	@Column(name = "USU_DS_SENHA")
	private String senha;

	@Size(max = 250)
	@Column(name = "USU_DS_NOME")
	private String nome;

	@Size(max = 11)
	@Column(name = "USU_NR_CPF")
	private String cpf;
	
	@Size(max = 250)
	@Column(name = "USU_DS_EMAIL")
	private String email;
	
	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(name = "USU_ST_ATIVO")
	private Boolean situacao;
	
}
