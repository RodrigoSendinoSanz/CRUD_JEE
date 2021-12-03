package com.eventos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventos.daos.IntUsuarioDao;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/usuario")
public class GestionUsuarios {

	@Autowired
	private IntUsuarioDao usuarioDao;


	@GetMapping("/")
	public String loginView() {
		return "login";
	}


	@GetMapping("/detalle")
	public String detallesUsuario(HttpServletRequest request, Model model) {
		if (request.getSession(false) == null)
			return "redirect:/usuario/";
		else if (request.getSession().getAttribute("usuarioSesion") == null)
			return "redirect:/usuario/";
		else
			return "detallesUsuario";
	}


	@GetMapping("/login")
	public String loginGET(HttpServletRequest request) {
		if (request.getSession(false) == null)
			return "redirect:/usuario/";
		else if (request.getSession().getAttribute("usuarioSesion") == null)
			return "redirect:/usuario/";
		else
			return "redirect:/";
	}


	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam("user") String user,
			@RequestParam("pass") String pass, RedirectAttributes rattr) {

		int id = usuarioDao.verificarDatos(user, pass);
		if (id != 0) {
			request.getSession().setAttribute("usuarioSesion", usuarioDao.findById(id));
			return "redirect:/";
		} else {
			rattr.addFlashAttribute("error_usuario", "No existe el usuario");
			return "redirect:/usuario/";
		}
	}

	@GetMapping("/logout")
	public String logout(WebRequest request) {
		request.removeAttribute("usuarioSesion", WebRequest.SCOPE_SESSION);
		return "redirect:/usuario/";
	}
}
