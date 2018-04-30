package com.wyden.nis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.wyden.nis.model.Perfil;
import com.wyden.nis.model.Unidade;

@Repository //Define a classe como um bean do Spring
public interface PerfilRepository extends JpaRepository<Perfil, Long> { 
	
	 @Query(value = "SELECT * from SEG_PERFIL where _ST_ATIVO = '1'", nativeQuery = true) 
	    public List<Perfil> getActiveProfiles();
	
	
} 
//Deve estender JpaRepository e declarar a entidade (Unity) e o tipo de chave primária (Long)