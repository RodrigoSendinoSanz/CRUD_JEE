package modelo.dao;

import java.util.List;

import modelo.beans.Evento;


public interface IntEventoDao {

	List<Evento>  findAll();
	
	Evento findById(int id_evento);
	
	List<Evento> activos();
	int altaEvento(Evento Evento);
	int eliminarEvento(int id_evento);
	
	/*int altaEvento(Evento evento);
	
	int editarEvento(Evento evento);
	int eliminarEvento(int id_evento);
	int cancelarEvento(int id_evento);
	 */
	
}
