package com.wyden.nis.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SEG_USUARIO_UNIDADE_PERFIL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public class UsuarioUnidadePerfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9077715000896374981L;

	@EmbeddedId
	private UsuarioUnidadePerfilID id;



}
