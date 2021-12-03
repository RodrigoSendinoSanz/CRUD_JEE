package com.edix.proyecto.modelo.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.edix.proyecto.modelo.beans.Perfile;



@Repository 
public class PerfilesDaoImplList implements IntPerfilesDao {
	
	private List<Perfile> lista;
	
	public PerfilesDaoImplList() {
		lista = new ArrayList<Perfile>();
		cargar();
	}
	
	private void cargar() {
		
		lista.add(new Perfile(1, "admin"));
		lista.add(new Perfile(2, "usuario"));
		lista.add(new Perfile(3, "trabajador"));
	}

	@Override
	public Perfile findById(int idPerfil) {
		Perfile aux = new Perfile();
		aux.setIdPerfil(idPerfil);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return null;
		}else
			return lista.get(pos);
	}

	@Override
	public List<Perfile> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	
	
}
