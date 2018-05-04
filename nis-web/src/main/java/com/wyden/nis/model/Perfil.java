package com.wyden.nis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "SEG_PERFIL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5285351846971957667L;

	public Perfil(Long id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PER_ID_PERFIL")
	private Long id;

	@NotBlank
	@Size(max = 150)
	@Column(name = "PER_DS_PERFIL")
	private String nome;

	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(name = "PER_ST_ATIVO")
	private Boolean situacao;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SEG_UNIDADE_PERFIL", joinColumns = @JoinColumn(name = "UPR_ID_PERFIL", referencedColumnName = "PER_ID_PERFIL"), inverseJoinColumns = @JoinColumn(name = "UPR_ID_UNIDADE", referencedColumnName = "UNI_ID_UNIDADE"))
	public Set<Unidade> unidade;

	@Transient
	public String getSituacaoName() {
		if (situacao == true) {
			return "Ativo";
		} else {
			return "Inativo";
		}
	}

}
