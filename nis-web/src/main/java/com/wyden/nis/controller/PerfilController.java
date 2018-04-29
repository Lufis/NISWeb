package com.wyden.nis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wyden.nis.model.Perfil;
import com.wyden.nis.model.Situacao;
import com.wyden.nis.service.PerfilService;
import com.wyden.nis.service.UnidadeService;


@Controller
@RequestMapping("/nis")
public class PerfilController {
	
	
	@Autowired
	private PerfilService perfilService;

	@DeleteMapping("/perfil/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		perfilService.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Perfil removido com sucesso!");
		
		return "redirect:/nis/perfil";
	}
	
	
	@GetMapping("/perfil")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("perfil/lista-perfil");
		modelAndView.addObject("perfis", perfilService.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/perfil/novo")
	public ModelAndView novo(Perfil perfil) {
		ModelAndView modelAndView = new ModelAndView("perfil/cadastro-perfil");
		
		modelAndView.addObject(perfil);	
		modelAndView.addObject("situacoes", Situacao.values());
		
		return modelAndView;
	}
	
	@PostMapping("/perfil/novo")
	public ModelAndView salvar(@Valid Perfil perfil, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(perfil);
		}
		
		perfilService.save(perfil);
		
		attributes.addFlashAttribute("mensagem", "Perfil criado com sucesso!");
		
		return new ModelAndView("redirect:/nis/perfil");
	}
	
	@GetMapping("/perfil/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(perfilService.findOne(id));
	}
}
