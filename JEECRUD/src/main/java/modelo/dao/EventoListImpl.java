package modelo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.beans.Evento;


public class EventoListImpl implements IntEventoDao,Serializable{
	
	private List<Evento> lista;
	
	public EventoListImpl() {
		lista = new ArrayList<Evento>();
		cargarDatos();
	}
	private void cargarDatos() {
		
		IntTipoDao itipo = new TipoListImpl();
		
			lista.add(new Evento(1, "Boda de Jesus Padilla", "Boda especial caracteristicas premium floriada", "12/12/2020", 220, "C/Pedro alfaro,2, 21", "ACTIVO", "A", 70, 20, 5000, itipo.findById(2)));
			lista.add(new Evento(2, "Boda de Juan Rubio", "Boda canciones del los 80", "10/12/2020", 140, "C/Pedro alfaro,2, 21",  "Hecho", "H", 50, 20, 2000, itipo.findById(1)));
			lista.add(new Evento(3, "Evento empresas", "Evento empresas sector agricola","9/11/2020", 200, "C/Ronda Don Bosco,10, 2", "ACTIVO", "H",50, 20, 1500, itipo.findById(4)));
			lista.add(new Evento(4, "Despedida soltero", "Despedida de soltero Jesus Padilla", "8/11/2020", 100, "C/Ronda Don Bosco,10, 2", "Hecho", "H", 20, 10, 890, itipo.findById(3)));
			lista.add(new Evento(5, "Cumple peque", "Cumple de Carlos Socas", "8/10/2020", 100, "C/Ronda Don Bosco,10, 2","ACTIVO", "H",20, 10, 890, itipo.findById(5)));
	}
	@Override
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public Evento findById(int id_evento) {
		Evento aux = new Evento();
		aux.setId_evento(id_evento);;
		
		int i = lista.indexOf(aux);
		if (i== -1)
			return null;
		else
			return lista.get(i);
	}
	@Override
	public List<Evento> activos() {
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public int altaEvento(Evento evento) {

		if (!lista.contains(evento)) {
			lista.add(evento);
			return 1;
		}else
			return 0;
	}
	public int editarEvento(Evento id_evento) {
		int i = lista.indexOf(id_evento);
		if (i == -1)
			return 0;
		else
			return (lista.set(i, id_evento) != null)?1:0;
	}
	
	@Override
	public int eliminarEvento(int id_evento) {
		Evento evento = findById(id_evento);
		
		if (evento == null) {
			return 0;
		}else
			return lista.remove(evento)?1:0;
	}
	public int cancelarEvento(int id_evento) {
		Evento evento = findById(id_evento);

		if (evento == null) {
			return 0;
		}else
			return lista.set(id_evento, evento) != null?1:0;
	}
	
}
