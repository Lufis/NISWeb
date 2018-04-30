package com.wyden.nis.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wyden.nis.model.Unidade;

@Repository //Define a classe como um bean do Spring
public interface UnidadeRepository extends JpaRepository<Unidade, Long> { 
	
	
	
    @Query(value = "SELECT new Unidade(UNI_DS_UNIDADE) from SEG_UNIDADE where UNI_ST_ATIVO = '1'", nativeQuery = true) 
    public List<Object[]> getActiveUnits();
	
} 
//Deve estender JpaRepository e declarar a entidade (Unity) e o tipo de chave primária (Long)