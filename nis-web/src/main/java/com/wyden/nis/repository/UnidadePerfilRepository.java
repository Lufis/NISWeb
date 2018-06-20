package com.wyden.nis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wyden.nis.model.Unidade;
import com.wyden.nis.model.UnidadePerfil;

@Repository
public interface UnidadePerfilRepository extends JpaRepository<UnidadePerfil, Long> {
	@Query("SELECT new Unidade(uni.id, uni.nome) FROM Unidade uni, UnidadePerfil uni_per WHERE uni_per.id.idUnidade = uni.id and uni_per.id.idPerfil = :idPerfil")
	public List<Unidade> getUnidadePerfil(@Param("idPerfil") Long idPerfil);
}
