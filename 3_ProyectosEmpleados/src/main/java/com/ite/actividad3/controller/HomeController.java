/**
 * 
 */
package com.ite.actividad3.controller;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.actividad3.model.beans.Empleado;
import com.ite.actividad3.model.repository.IntEmpleadoDao;

/**
 * @author jsant
 *
 */
@Controller

public class HomeController {
	
	@Autowired
	private IntEmpleadoDao edao;

	@GetMapping("/")
	public String incioLogin() {
		
		return "home/login";
	}
	
	@PostMapping("/login")
	public String empleadoLogueado(Model model, 
			HttpSession misesion ,@RequestParam("idEmpl") int idEmpl,
			@RequestParam("correo") String correo, 
			@RequestParam("password") String password) {
		
		Empleado empleado = edao.findByIdEmplAndCorreoAndPassword(idEmpl, correo, password);
		
		
	   if(empleado != null) {
		   
			   int idPerfil = empleado.getPerfile().getIdPerfil();
			   String literal = null;
			   switch (idPerfil) {
			   
			   		case 1: 
			   			literal = "gestion";
			   			break;
			   		case 2:
			   			literal = "jefe";
			   			break;
			   		case 3: 
			   			literal = "empleado";
			   			break;
			   		case 4: 
			   			literal = "RRHH";
			   			break;
			   }
			   
			    	misesion.setAttribute("empleado", empleado);
				   return "redirect:/"+literal+"/"; 
			  
		   }else {
			  model.addAttribute("mensaje", "El usuario o la contraseña o el correo no son correctos");
			   return "home/login";
		   }  
	   
	}
	
	/**
	 * Método para cerrar la sesión del usuario.
	 * @param model
	 * @return
	 */
	@GetMapping("/cerrarSesion")
	public String cierreSesion(Model model, RedirectAttributes ratt, HttpSession misesion) {

		misesion.removeAttribute("empleado");
		misesion.invalidate();
		model.addAttribute("mensaje", "Sesíon cerrada");
		return "forward:/";
	}
	
}
