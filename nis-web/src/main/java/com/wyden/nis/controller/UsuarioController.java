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

import com.wyden.nis.model.Situacao;
import com.wyden.nis.model.Usuario;
import com.wyden.nis.service.PerfilService;
import com.wyden.nis.service.UnidadeService;
import com.wyden.nis.service.UsuarioService;

@Controller
@RequestMapping("/nis")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UnidadeService unidadeService;
	@Autowired
	private PerfilService perfilService;

	@DeleteMapping("/usuario/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		usuarioService.delete(id);

		attributes.addFlashAttribute("mensagem", "Usuário removido com sucesso!");

		return "redirect:/nis/usuario";
	}

	@GetMapping("/usuario")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("usuario/lista-usuario");
		modelAndView.addObject("usuarios", usuarioService.findAll());
		return modelAndView;
	}

	@GetMapping("/usuario/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuario/cadastro-usuario");
		modelAndView.addObject("unidades", unidadeService.findActiveUnity());
		modelAndView.addObject("perfis", perfilService.findPerfilAtivo());
		modelAndView.addObject("situacoes", Situacao.values());
		modelAndView.addObject(usuario);
		return modelAndView;
	}

	@PostMapping("/usuario/novo")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuario);
		}

		usuarioService.save(usuario);

		attributes.addFlashAttribute("mensagem", "Usuário criado com sucesso!");

		return new ModelAndView("redirect:/nis/usuario");
	}

	@GetMapping("/usuario/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(usuarioService.findOne(id));
	}
}
