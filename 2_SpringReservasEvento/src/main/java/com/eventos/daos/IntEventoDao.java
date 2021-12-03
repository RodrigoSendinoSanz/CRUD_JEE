package com.eventos.daos;

import com.eventos.beans.Evento;

import java.util.List;

public interface IntEventoDao {
	Evento findById(int idEvento);
	List<Evento> findAll();
	List<Evento> findActivos();
	List<Evento> findDestacados();
}
