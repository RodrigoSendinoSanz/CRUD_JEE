package com.ite.actividad3.model.repository;

import java.util.List;

import com.ite.actividad3.model.beans.ProyectoConProducto;

public interface IntProyectoConProductosDao {
	
	List<ProyectoConProducto> findAll();
	public List<ProyectoConProducto> listaproductosAsignadosAProyecto(String idProyecto);
}
