package com.ite.actividad3.model.repository;

import java.util.List;

import com.ite.actividad3.model.beans.Perfile;

public interface IntPerfileDao {
	
	List<Perfile> findAll(); //Devuelve todos los perfiles
	Perfile findById(int idPerfil); //Busca un perfil determinado
	int altaPerfil(Perfile perfile); //Da de alta un perfil
	int editarPerfile(Perfile perfile); //Edita un perfil
	int eliminarPerfile(Perfile perfile); //elimina un perfil
	
}
