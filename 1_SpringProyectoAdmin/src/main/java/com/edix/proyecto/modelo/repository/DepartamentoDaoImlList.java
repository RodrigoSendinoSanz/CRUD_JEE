package com.edix.proyecto.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyecto.modelo.beans.Departamento;




@Repository 
public class DepartamentoDaoImlList  implements IntDepartamentoDao{
	private List<Departamento> lista;
	
	public DepartamentoDaoImlList() {
		lista = new ArrayList<Departamento>();
		cargar();
	}
	
	private void cargar() {
		
		IntEmpladoDao edao = new EmpleadoDaoImplList();
		
		lista.add(new Departamento(1, "Planta 3 roja", "Dep.Marketing", edao.findById(1)));
		lista.add(new Departamento(2, "Planta 4 verde", "Dep.Ventas",  edao.findById(2)));
		lista.add(new Departamento(2, "Planta 5 amarillo", "Dep.Administracion", edao.findById(3)));
	}
	
	public Departamento findById(int idDepar) {
		Departamento departamento = new Departamento();
		departamento.setIdDepar(idDepar);
		int pos = lista.indexOf(departamento);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
}
