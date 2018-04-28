package com.wyden.nis.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.NotBlank;

import com.wyden.nis.core.model.commons.converter.BooleanConverter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tbl_perfil")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5285351846971957667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PER_ID_PERFIL")
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "PER_DS_PERFIL")
	private String nome;
	
	@NotBlank
	@Convert(converter = BooleanConverter.class)
	@Column(name = "PER_ST_ATIVO")
	private Boolean situacao;

	/*
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "perfil_unidade", joinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "unidade_id", referencedColumnName = "id"))
	public Set<Unidade> unidade;
*/
}
