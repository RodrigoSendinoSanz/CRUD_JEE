package com.edix.proyecto.modelo.repository;

import java.util.List;

import com.edix.proyecto.modelo.beans.Perfile;



public interface IntPerfilesDao {
	Perfile findById(int idPerfil);
	List<Perfile> findAll();
}
