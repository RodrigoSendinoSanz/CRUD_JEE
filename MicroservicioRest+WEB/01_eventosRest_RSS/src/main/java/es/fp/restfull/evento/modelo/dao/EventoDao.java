package es.fp.restfull.evento.modelo.dao;

import java.util.List;

import es.fp.restfull.evento.modelo.entitybeans.Evento;

public interface EventoDao {
	List<Evento> findAll();
	Evento verUno(int idEvento);
	int insertar(Evento evento);
	int modificar (Evento evento);
	int eliminar (int idEvento);
	List<Evento> verActivos();
	List<Evento> verDestacados();
	List<Evento> buscarEvento(String dato);
}
