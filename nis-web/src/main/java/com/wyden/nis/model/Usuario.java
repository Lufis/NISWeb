package com.wyden.nis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tbl_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7184637490708124592L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 80)
	@NotBlank
	private String nome;

	@Column(nullable = false, length = 50)
	@NotBlank
	private String login;

	@Column(nullable = false, length = 50)
	@NotBlank
	private String perfil;

	@Column(nullable = false, length = 50)
	@NotBlank
	private String unidade;

	@Column(nullable = false, length = 50)
	@NotNull
	private String senha;

	@Column(nullable = false, length = 50)
	@NotNull
	private String email;
	
	@Column(nullable = false, length = 50)
	@NotNull
	private String estado;
	
}
