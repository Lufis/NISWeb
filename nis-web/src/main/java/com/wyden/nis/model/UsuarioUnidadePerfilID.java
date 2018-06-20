package com.wyden.nis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "idUnidade", "idPerfil" })

public class UsuarioUnidadePerfilID implements Serializable {
 
    /**
	 * 
	 */

	
	private static final long serialVersionUID = 1L;

	@Column(name = "UUP_ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "UPP_ID_UNIDADE")
	private Long idUnidade;
	
	
	@Column(name = "UPP_ID_PERFIL")
	private Long idPerfil;
 


 
    
}