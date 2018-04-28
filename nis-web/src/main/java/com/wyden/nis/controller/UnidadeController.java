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

import com.wyden.nis.model.Estado;
import com.wyden.nis.model.Unidade;
import com.wyden.nis.service.UnidadeService;

@Controller
@RequestMapping("/nis")
public class UnidadeController {

	@Autowired
	private UnidadeService unidadeService;

	@DeleteMapping("/unidade/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		unidadeService.delete(id);
		attributes.addFlashAttribute("mensagem", "Unidade removida com sucesso!");
		return "redirect:/nis/unidade";
	}

	@GetMapping("/unidade")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("unidade/lista-unidades");
		modelAndView.addObject("unidades", unidadeService.findAll());
		return modelAndView;
	}

	@GetMapping("/unidade/novo")
	public ModelAndView novo(Unidade unidade) {
		ModelAndView modelAndView = new ModelAndView("unidade/cadastro-unidade");
		modelAndView.addObject("estados", Estado.values());
		modelAndView.addObject(unidade);

		return modelAndView;
	}

	@PostMapping("/unidade/novo")
	public ModelAndView salvar(@Valid Unidade unidade, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(unidade);
		}

		unidadeService.save(unidade);
		attributes.addFlashAttribute("mensagem", "Unidade criada com sucesso!");
		return new ModelAndView("redirect:/nis/unidade");
	}

	@GetMapping("/unidade/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(unidadeService.findOne(id));
	}
}
