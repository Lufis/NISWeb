package com.wyden.nis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wyden.nis.model.Perfil;

@Repository //Define a classe como um bean do Spring
public interface PerfilRepository extends JpaRepository<Perfil, Long> { } 
//Deve estender JpaRepository e declarar a entidade (Unity) e o tipo de chave primária (Long)