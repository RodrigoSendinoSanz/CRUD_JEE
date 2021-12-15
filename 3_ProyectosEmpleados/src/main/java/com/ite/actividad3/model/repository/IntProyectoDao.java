package com.ite.actividad3.model.repository;

import java.util.List;


import com.ite.actividad3.model.beans.Proyecto;

public interface IntProyectoDao {

	List<Proyecto> findAll(); //Devuelve una lista con todos los proyectos
	Proyecto findById(String idProyecto); //Devuelve el proyecto
	int altaProyecto(Proyecto proyecto); //Da de alta un proyecto
	int editaProyecto(Proyecto proyecto); //Edita un proyecto
	int bajaProyecto (Proyecto proyecto); //Da de baja un proyecto
	List<Proyecto> muestraActivos(); //Devuelve una lista con los proyectos activos
	List<Proyecto> muestraTerminados(); //Devuelve una lista con los proyectos activos
	List<Proyecto> proyActivosPorJefe(int idEmpl);
	Proyecto asignarEmpleadosAProyecto(String idProyecto);
}
