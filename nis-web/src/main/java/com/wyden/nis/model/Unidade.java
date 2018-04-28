package com.wyden.nis.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.wyden.nis.core.model.commons.converter.BooleanConverter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tbl_unidade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Unidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9077715000896374981L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UNI_ID_UNIDADE")
	private Long id;

	@NotBlank
	@Size(max = 150)
	@Column(name = "UNI_DS_UNIDADE")
	private String nome;
	
	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(name = "UNI_ST_ATIVO")
	private Boolean situacao;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "UNI_DS_URLINTERNO")
	private String urlInterno;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "UNI_DS_URLEXTERNO")
	private String urlExterno;
	
	
	/*
	@ManyToMany(mappedBy = "unidade")
	private Set<Perfil> perfil;
*/
}
