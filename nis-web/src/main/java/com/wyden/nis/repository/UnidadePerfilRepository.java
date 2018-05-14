package com.wyden.nis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wyden.nis.model.UnidadePerfil;

@Repository 
public interface UnidadePerfilRepository extends JpaRepository<UnidadePerfil, Long> {

}
