package com.edix.proyecto.modelo.repository;

import java.util.List;

import com.edix.proyecto.modelo.beans.Empleado;


public interface IntEmpladoDao {

	int comprobarLogin(int idEmpl, String correo, String password);

	List<Empleado> findAll();

	Empleado findById(int idEmpl);

}
