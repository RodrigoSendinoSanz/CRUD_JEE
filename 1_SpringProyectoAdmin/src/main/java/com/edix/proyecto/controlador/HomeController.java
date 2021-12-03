package com.edix.proyecto.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.proyecto.modelo.beans.Empleado;
import com.edix.proyecto.modelo.repository.IntEmpladoDao;


;

@Controller
public class HomeController {
	
	@Autowired
	private IntEmpladoDao iemp;
	
	@GetMapping("/")
	public String login(Model model) {
		System.out.println("get mappaing home controller");
		return "login";
	}
	

	@PostMapping("/loginvalidar")
	public String login(HttpServletRequest request,Empleado empleado, @RequestParam("idEmpl") int idEmpl,
			@RequestParam("correo") String correo,@RequestParam("password") String paswword,HttpSession session, RedirectAttributes rattr) {
		System.out.println(idEmpl);
		System.out.println(correo);
		System.out.println(paswword);
		Empleado aux = iemp.findById(idEmpl);
		int val = iemp.comprobarLogin(idEmpl, correo,paswword);
		switch(val)
		{
		   case 1 :
			   rattr.addFlashAttribute("mensaje", "Bienvenido usuario "+aux.getNombre());
				System.out.println(aux.getNombre());
				System.out.println(aux.getPerfile());
				request.getSession().setAttribute("usuarioSesion", iemp.findById(idEmpl));
				return "redirect:/gestion/inicio";
		   
		   case 2 :
			   rattr.addFlashAttribute("mensaje", "Bienvenido admin "+aux.getNombre());
				request.getSession().setAttribute("usuarioSesion", iemp.findById(idEmpl));
				System.out.println("Session admin");
				return "redirect:/jefe/proyectos";

		   default : 
			   rattr.addFlashAttribute("error_usuario", "No existe el usuario");
			 return "redirect:/error/";
		}

		

	}
}
