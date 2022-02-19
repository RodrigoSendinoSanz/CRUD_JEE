package es.fp.restfull.evento.modelo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.fp.restfull.evento.modelo.repository.ReservaRepository;


@Repository
public class ReservasDaoImpl implements ReservasDao{
	
	@Autowired
	private ReservaRepository rrepo;
	

	@Override
	public int buscarPlazas(int idEvento) {
		return  rrepo.buscarPlazas(idEvento);//NoJSON , restar cantidad a plazas
	}
	 

}
