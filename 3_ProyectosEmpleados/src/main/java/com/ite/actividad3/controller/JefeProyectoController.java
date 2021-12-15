package com.ite.actividad3.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import com.ite.actividad3.model.beans.Empleado;
import com.ite.actividad3.model.beans.Proyecto;
import com.ite.actividad3.model.beans.ProyectoConEmpleado;
import com.ite.actividad3.model.beans.ProyectoConProducto;
import com.ite.actividad3.model.repository.IntEmpleadoDao;
import com.ite.actividad3.model.repository.IntProyectoConEmpleadosDao;
import com.ite.actividad3.model.repository.IntProyectoConProductosDao;
import com.ite.actividad3.model.repository.IntProyectoDao;
import com.ite.actividad3.model.repository.ProyectoConEmpleadoDaoImpl;

@Controller
@RequestMapping("/jefe")
public class JefeProyectoController {

	@Autowired
	IntProyectoDao proyDao;
	@Autowired
	IntEmpleadoDao emplDao;
	@Autowired
	IntProyectoConEmpleadosDao conEmpleadosDao;
	@Autowired
	IntProyectoConProductosDao conProductosDao;
	
	
	
	@GetMapping("/")
	public String indexJefe(Model model, HttpSession misesion) {
		Empleado empleado = (Empleado)misesion.getAttribute("empleado");
		List<Proyecto> misProyectos = proyDao.proyActivosPorJefe(empleado.getIdEmpl());
		model.addAttribute("proyectosJefe", misProyectos);
		return "jefe/jpIndex";
	}
	
	
	@GetMapping("/verDetalle/{id}")
	public String verDetalleProyecto(Model model, @PathVariable("id") String idProyecto, HttpSession misesion) {
		Proyecto proyecto = proyDao.findById(idProyecto);
		proyecto.setProyectoConEmpleados(conEmpleadosDao.listaEmpleadosAsignadosAProyecto(idProyecto));
		proyecto.setProyectoConProductos(conProductosDao.listaproductosAsignadosAProyecto(idProyecto));
		
		model.addAttribute("proyecto", proyecto);
		
		misesion.setAttribute("proyectoAsignar", proyecto);
		return "jefe/detalleProyecto";
	}
	
	
	@InitBinder
	public void initBinder (WebDataBinder webdataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
}
