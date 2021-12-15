package com.ite.actividad3.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.actividad3.model.beans.Cliente;
import com.ite.actividad3.model.beans.Empleado;
import com.ite.actividad3.model.beans.Producto;
import com.ite.actividad3.model.beans.Proyecto;
import com.ite.actividad3.model.repository.IntClienteDao;
import com.ite.actividad3.model.repository.IntEmpleadoDao;
import com.ite.actividad3.model.repository.IntProductoDao;
import com.ite.actividad3.model.repository.IntProyectoConEmpleadosDao;
import com.ite.actividad3.model.repository.IntProyectoConProductosDao;
import com.ite.actividad3.model.repository.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class ControldGestionController {

	@Autowired
	IntClienteDao cliDao;
	@Autowired
	IntProyectoDao proyDao;
	@Autowired
	IntProductoDao prodDao;
	@Autowired
	IntEmpleadoDao emplDao;
	@Autowired
	IntProyectoConEmpleadosDao conEmpleadosDao;
	@Autowired
	IntProyectoConProductosDao conProductosDao;
	
	
	@GetMapping("/")
	public String inicioGestion(Model model) {
		List<Proyecto> lista = proyDao.muestraActivos();
		model.addAttribute("listaProyectosActivos", lista);
		return "gestion/indexGestion";
	}
	
	@GetMapping("/altaProyecto")
	public String mostrarAltaProyecto(Model model) {
		model.addAttribute("jefesProyecto", emplDao.mostrarJefes());
		model.addAttribute("clientes", cliDao.findAll());
		
		return "gestion/altaProyecto";
	}
	
	@PostMapping("/altaProyecto")
	public String procAltaProyecto(Proyecto proyecto, RedirectAttributes rdattr, @RequestParam("cliente.cif") String cif, @RequestParam("empleado.idEmpl") int idEmpl) {
		
		proyecto.setCliente(cliDao.findById(cif));
		proyecto.setJefeProyecto(emplDao.findById(idEmpl));
		if (proyDao.altaProyecto(proyecto) == 1) 
			rdattr.addFlashAttribute("mensaje", "alta proyecto completada");
		else
			rdattr.addFlashAttribute("mensaje", "alta proyecto ERRONEA");
		
	
		return "redirect:/gestion/";

	}
	
	
	@GetMapping("/terminarProyecto/{id}")
	public String mostrarTerminarProyecto(Model model, @PathVariable("id") String idProyecto) {
		model.addAttribute("proyecto", proyDao.findById(idProyecto));
		return "gestion/formTerminaProy";
	}
	
	/**
	 * Procesa el formulario para terminar un proyecto
	 * @param ratt Envia los mensajes de confirmación
	 * @param idProyecto 
	 * @param estado
	 * @param fechaFinReal
	 * @param costeReal
	 * @return El listado de los proyectos terminados
	 */
	@PostMapping("/terminarProyecto")
	public String procTerminarProyecto(RedirectAttributes ratt, 
			@RequestParam("idProyecto") String idProyecto, 
			@RequestParam("fechaFinReal") Date fechaFinReal, 
			@RequestParam("costeReal") BigDecimal costeReal) {
			
		Proyecto proy = proyDao.findById(idProyecto);
		proy.setEstado("terminado");
		proy.setCosteReal(costeReal);
		proy.setFechaFinReal(fechaFinReal);
		
		int result = proyDao.editaProyecto(proy);
		
		if(result == 0) {
			ratt.addFlashAttribute("mensaje", "Ha fallado la operación");
			return "redirect:/gestion/";
		}else {
			ratt.addFlashAttribute("mensaje", "El proyecto se ha finalizado correctamente");
			return "redirect:/gestion/";
		}
	}
	
	@GetMapping("/verProyecto/{id}")
	public String mostrarVerDetalleProyecto(Model model, @PathVariable("id") String idProyecto) {
		Proyecto proyecto = proyDao.findById(idProyecto);
		proyecto.setProyectoConEmpleados(conEmpleadosDao.listaEmpleadosAsignadosAProyecto(idProyecto));
		proyecto.setProyectoConProductos(conProductosDao.listaproductosAsignadosAProyecto(idProyecto));
		model.addAttribute("proyecto", proyecto);
		
		return "gestion/verProyecto";
	}
	
	
	
	@InitBinder
	public void initBinder (WebDataBinder webdataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
}
