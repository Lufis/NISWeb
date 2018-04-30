package com.wyden.nis.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wyden.nis.model.Unidade;

@Repository //Define a classe como um bean do Spring
public interface UnidadeRepository extends JpaRepository<Unidade, Long> { 
	
	
	
    @Query("SELECT new Unidade(entity.id, entity.nome) FROM Unidade entity WHERE entity.situacao = TRUE ") 
    public List<Unidade> getUnidadesAtivas();
	
} 
//Deve estender JpaRepository e declarar a entidade (Unity) e o tipo de chave primária (Long)