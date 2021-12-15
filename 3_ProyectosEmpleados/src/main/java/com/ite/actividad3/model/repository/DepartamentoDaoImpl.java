package com.ite.actividad3.model.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Departamento;


@Repository
public class DepartamentoDaoImpl implements IntDepartamentoDao {

	List<Departamento> lista;
	
	public DepartamentoDaoImpl() {
		
		lista = new ArrayList<Departamento>();
		
		cargarDatos();
	}
	
	private void cargarDatos() {
		
		lista.add(new Departamento(10, "Madrid" ,"Direccion"));
		lista.add(new Departamento(20, "Madrid" ,"RRHH"));
		lista.add(new Departamento(30, "Madrid" ,"Operaciones"));
		lista.add(new Departamento(40, "Madrid" ,"Financiero"));
		
	}
	
	/**
	 * @return Devuelve la lista con los departamentos
	 */
	@Override
	public List<Departamento> findAll() {
		
		return lista;
	}

	/**
	 * @param int Recibe el id del departamento
	 * @return un objeto Departamento con el departamento que buscamos
	 */
	@Override
	public Departamento findById(int idDepar) {
		Departamento aux = new Departamento();
		aux.setIdDepar(idDepar);
		int pos = lista.indexOf(aux);
		
		if(pos == -1)
			return null;
		else
			return lista.get(pos)==null?null:lista.get(pos);
	}

	/**
	 * @param Departamento Recibe un obejto departamento
	 * @return 1 si puede hacer el alta, 0 si ha fallado
	 */
	@Override
	public int altaDepartamento(Departamento departamento) {
		
		return lista.add(departamento)?1:0;
	}

	/**
	 * @param Departamento Recibe un objeto departamento
	 * @return Devuelve 1 si lo ha podido editar, 0 en caso contrario
	 */
	@Override
	public int editaDepartamento(Departamento departamento) {
		int pos= lista.indexOf(departamento);
		
		return lista.set(pos, departamento)!=null?1:0;
	}

	/**
	 * @param Departamento Recibe un obejeto departamento
	 * @return 1 si le ha dado de baja, 0 si no puede dar de baja
	 */
	@Override
	public int bajaDepartamento(Departamento departamento) {
		
		return lista.remove(departamento)?1:0;
	}

}
