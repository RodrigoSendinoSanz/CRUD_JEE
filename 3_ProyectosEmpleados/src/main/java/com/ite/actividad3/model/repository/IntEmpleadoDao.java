package com.ite.actividad3.model.repository;

import java.util.List;

import com.ite.actividad3.model.beans.Empleado;

public interface IntEmpleadoDao {

	List<Empleado> findAll(); //Devuelve una lista con todos los empleados
	Empleado findByIdEmplAndCorreoAndPassword(int idEmpl, String correo, String password);
	Empleado findById(int idEmpl); //Devuelve un objeto de tipo Empleado con el empleado que buscamos
	int altaEmpleado(Empleado empleado); //Da de alta un empleado
	int editarEmpleado(int idEmpl); //Devuelve el empleado dado
	int borrarEmpleado(int idEmpl); //Borra el empleado del id dado
	int asignaId(); //Asigna de forma automática el último id
	List<Empleado> mostrarJefes(); //
	List<Empleado> operativosSinAsignarAProyectos();
	List<Empleado> findOperativos();
}
