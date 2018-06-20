package com.wyden.nis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.nis.model.Unidade;
import com.wyden.nis.model.UnidadePerfil;
import com.wyden.nis.repository.UnidadePerfilRepository;

@Service
public class UnidadePerfilService {

	@Autowired
	private UnidadePerfilRepository repository;

	public List<UnidadePerfil> findAll() {
		return repository.findAll();
	}

	public UnidadePerfil findOne(Long id) {
		return repository.getOne(id);
	}

	public UnidadePerfil save(UnidadePerfil UnidadePerfil) {
		return repository.saveAndFlush(UnidadePerfil);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public String findUnidadesPerfil(Long idPerfil) {
		StringBuilder textListUnidadePerfil = new StringBuilder();

		List<Unidade> listUnidadePerfil = null;
		listUnidadePerfil = repository.getUnidadePerfil(idPerfil);
		for (Unidade unidadePerfil : listUnidadePerfil) {
			if (listUnidadePerfil.indexOf(unidadePerfil) == (listUnidadePerfil.size() - 1)) {
				textListUnidadePerfil.append(unidadePerfil.getNome());
			} else {
				textListUnidadePerfil.append(unidadePerfil.getNome()).append( ", \t");
			}

		}

		return textListUnidadePerfil.toString();
	}
}