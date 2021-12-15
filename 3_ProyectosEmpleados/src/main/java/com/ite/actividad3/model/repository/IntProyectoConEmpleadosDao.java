package com.ite.actividad3.model.repository;

import java.util.List;

import com.ite.actividad3.model.beans.Empleado;
import com.ite.actividad3.model.beans.ProyectoConEmpleado;

public interface IntProyectoConEmpleadosDao {

	List<ProyectoConEmpleado> findAll();
	List<ProyectoConEmpleado> listaEmpleadosAsignados();
	List<ProyectoConEmpleado> listaEmpleadosAsignadosAProyecto(String idProyecto);
	int insertarEmpleado(ProyectoConEmpleado proyectoConEmpleado);
	
	
}
