package com.eventos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eventos.daos.IntEventoDao;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @Autowired
    private IntEventoDao eventoDao;


    @GetMapping("/")
    public String inicio(HttpServletRequest request, Model model) {
        if (request.getSession(false) == null)
            return "redirect:/usuario/";
        else if(request.getSession().getAttribute("usuarioSesion") == null)
        	return "redirect:/usuario/";
        else
            model.addAttribute("eventoDao", eventoDao.findAll());
            return "index";
    }


    @GetMapping("/activos")
    public String eventosActivos(Model model) {
    	model.addAttribute("eventos", eventoDao.findActivos());
        model.addAttribute("tipoListar", "activos");
        return "listarEventos";
    }

    @GetMapping("/destacados")
    public String eventosDestacados(Model model) {
    	model.addAttribute("eventos", eventoDao.findDestacados());
        model.addAttribute("tipoListar", "destacados");
        return "listarEventos";
    }

}
