package com.wyden.nis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.nis.model.Perfil;
import com.wyden.nis.model.Unidade;
import com.wyden.nis.repository.PerfilRepository;


@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;

	public List<Perfil> findAll() {
		return repository.findAll();
	}

	public Perfil findOne(Long id) {
		return repository.getOne(id);
	}

	public Perfil save(Perfil perfil) {
		return repository.saveAndFlush(perfil);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Perfil> findPerfisAtivos() {
		return repository.getPerfisAtivos();
	}
}