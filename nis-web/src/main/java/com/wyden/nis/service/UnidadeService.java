package com.wyden.nis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyden.nis.model.Unidade;
import com.wyden.nis.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository repository;

	public List<Unidade> findAll() {
		return repository.findAll();
	}

	public Unidade findOne(Long id) {
		return repository.getOne(id);
	}

	public Unidade save(Unidade Unidade) {
		return repository.saveAndFlush(Unidade);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public List<Unidade> findActiveUnity() {
		return repository.getUnidadesAtivas();
	}
}