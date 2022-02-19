package es.fp.restfull.evento.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.fp.restfull.evento.modelo.entitybeans.Evento;
import es.fp.restfull.evento.modelo.repository.EventoRepository;

@Repository
public class EventoDaoImpl implements EventoDao{

	@Autowired
	private EventoRepository erepo;
	
	@Override
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public Evento verUno(int idEvento) {
		// TODO Auto-generated method stub
		return erepo.findById(idEvento).orElse(null);
	}

	@Override
	public int insertar(Evento evento) {
		
		if(verUno(evento.getIdEvento()) == null) {
			erepo.save(evento);
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public int modificar(Evento evento) {
		if(verUno(evento.getIdEvento()) != null) {
			erepo.save(evento);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int eliminar(int idEvento) {
		if(verUno(idEvento) != null) {
			erepo.deleteById(idEvento);
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public List<Evento> verActivos() {
		// TODO Auto-generated method stub
		return erepo.buscarActivos();
	}

	@Override
	public List<Evento> verDestacados() {
		// TODO Auto-generated method stub
		return erepo.buscarDestacados();
	}

	@Override
	public List<Evento> buscarEvento(String dato) {
		// TODO Auto-generated method stub
		return erepo.buscarEvento(dato);
	}



}
