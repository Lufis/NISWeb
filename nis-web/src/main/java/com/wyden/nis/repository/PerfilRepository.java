package com.wyden.nis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wyden.nis.model.Perfil;

@Repository 
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	@Query("SELECT new Perfil(entity.id, entity.nome) from Perfil entity where entity.situacao = true")
	public List<Perfil> getPerfisAtivos();
	


}
