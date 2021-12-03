package com.edix.proyecto.modelo.repository;

import java.util.List;

import com.edix.proyecto.modelo.beans.Proyecto;

public interface IntProyectoDao {

	List<Proyecto> findAll();
	int altaProyecto(Proyecto proyecto);
	Proyecto findById(int idProyecto);
	int terminarProyecto(int idProyecto);

}
