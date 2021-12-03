package com.edix.proyecto.controlador;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.proyecto.modelo.beans.Proyecto;
import com.edix.proyecto.modelo.repository.ClienteDaoImplList;
import com.edix.proyecto.modelo.repository.EmpleadoDaoImplList;
import com.edix.proyecto.modelo.repository.IntClienteDao;
import com.edix.proyecto.modelo.repository.IntEmpladoDao;
import com.edix.proyecto.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class ControlGestion {
	
	@Autowired
	private IntProyectoDao iproye;

	@GetMapping("/inicio")
	public String activos(Model model) {		
		model.addAttribute("listaProyectos",iproye.findAll());
		return "inicio";
	}
	
	@GetMapping("/altaProyecto")
	public String altaproyecto(Model model) {
		model.addAttribute("listaProyectos",iproye.findAll());
		return "altaProyecto";
	}
	
	@PostMapping("/alta")
	public String altaproyectopost(Model model,@RequestParam("costeReal") BigDecimal costeReal,@RequestParam("costesPrevisto") BigDecimal costesPrevisto,
			@RequestParam("descripcion") String descripcion,@RequestParam("estado") String estado, @RequestParam("ventaPrevisto") BigDecimal ventaPrevisto,@RequestParam("cliente") String cliente,@RequestParam("jefeProyecto") String jefeProyecto) {
		int i=0;
		switch (jefeProyecto) {
		case "Jose":
			System.out.println("el nombre es "+jefeProyecto);
			i=1;
			break;
		case "Ana":
			System.out.println("el nombre es "+jefeProyecto);
			i=2;
			break;
		case "Pepe":
			System.out.println("el nombre es "+jefeProyecto);
			i=3;
			break;
		default:
			break;
		}
		String c= new String();
		c="";
		switch (cliente) {
		case "AutocaresRamirez.S.L":
			System.out.println("el cliente es "+jefeProyecto);
			c="23729390P";
			break;
		case "TaxiSport.S.L":
			System.out.println("el cliente es "+jefeProyecto);
			c="12349390P";
			break;
		case "Uber.S.L":
			System.out.println("el cliente es "+jefeProyecto);
			c="12349390P";
			break;
		default:
			break;
		}
		IntEmpladoDao edao = new EmpleadoDaoImplList();
		IntClienteDao cdao = new ClienteDaoImplList();
		int val = 0;
		iproye.altaProyecto(new Proyecto(val, costeReal, costesPrevisto, descripcion, estado, new Date(), new Date(), new Date(), ventaPrevisto, cdao.findById(c), edao.findById(i)));
		model.addAttribute("listaProyectos",iproye.findAll());
		return "inicio";
	}
	
	
	@GetMapping("/terminarProyecto/{idProyecto}")
	public String terminarProyecto(Model model,@PathVariable("idProyecto") int idProyecto,RedirectAttributes rattr) {
		System.out.println("Pasando por terminar proyecto");
		int result = iproye.terminarProyecto(idProyecto);
		if (result == 1) {
			rattr.addFlashAttribute("mensaje", "Proyecto terminado");
			return "redirect:/gestion/inicio";
		}else {
			rattr.addFlashAttribute("mensaje", "Proyecto NO terminado");
		return "redirect:/gestion/inicio";
		}
	}
	
	
	@GetMapping("/CerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("nombre");
		return "redirect:/";
	}
	
	@GetMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("listaProyectos",iproye.findAll());
		return "todos";
	}
	

}
