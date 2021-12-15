package com.ite.actividad3.model.repository;

import java.util.List;

import com.ite.actividad3.model.beans.Departamento;

public interface IntDepartamentoDao {

	List<Departamento> findAll(); //Devuelve la lista de los departamentos
	Departamento findById(int idDepar); // Devuelve el departamento buscado
	int altaDepartamento(Departamento departamento); //Da de alta un nuevo departamento
	int editaDepartamento(Departamento departamento); //Edita un departamento
	int bajaDepartamento(Departamento departamento); //Da de baja un departamento
}
