package com.edix.proyecto.modelo.repository;

import java.util.List;

import com.edix.proyecto.modelo.beans.Departamento;



public interface IntDepartamentoDao {

	List<Departamento> findAll();
	Departamento findById(int idEmpl);
}
