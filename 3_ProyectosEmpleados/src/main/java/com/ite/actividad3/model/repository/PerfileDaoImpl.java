package com.ite.actividad3.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Perfile;
@Repository
public class PerfileDaoImpl implements IntPerfileDao {
	
	private List<Perfile> lista;
	
	public PerfileDaoImpl() {
		
		lista = new ArrayList<Perfile>();
		
		lista.add(new Perfile(1, "Control de Gestión"));
		lista.add(new Perfile(2, "Jefe de Proyecto"));
		lista.add(new Perfile(3, "Operativo"));
		lista.add(new Perfile(4, "Recursos Humanos"));
	}
	
	

	/**
	 * Devuelve la lista de los perfiles de empleados
	 */
	@Override
	public List<Perfile> findAll() {
		return lista;
	}

	/**
	 * @param Recibe el id del pefil que se busca y devuelve el objeto
	 * de dicho perfil
	 */
	@Override
	public Perfile findById(int idPerfil) {
		Perfile aux = new Perfile();
		aux.setIdPerfil(idPerfil);
		int pos=lista.indexOf(aux);
		
		if(pos == -1)
				return null;
		else
			return lista.get(pos);
						
	}

	/**
	 * @param Recibe un objeto perfile para darlo de alta
	 * Si el alta es correcto devuelve 1, sino devuelve 0
	 */
	@Override
	public int altaPerfil(Perfile perfile) {
		
		return (lista.contains(perfile))?0:(lista.add(perfile))?1:0;
	}

	/**
	 * @param recibe el id del perfil que se quiere editar
	 * devuelve 1 si se ha podido editar, 0 si no es el caso
	 */
	@Override
	public int editarPerfile(Perfile perfile) {
		int pos = lista.indexOf(perfile);
		
		if(pos == -1)
			return 0;
		else
			return lista.set(pos, perfile)!=null?1:0;
	}

	/**
	 * @param recibe el id del pefil que se quiere eliminar
	 * devuelve 1 si lo elimina, 0 si no se ha podido realizar.
	 */
	@Override
	public int eliminarPerfile(Perfile perfile) {
		return lista.remove(perfile)?1:0;
	}

}
