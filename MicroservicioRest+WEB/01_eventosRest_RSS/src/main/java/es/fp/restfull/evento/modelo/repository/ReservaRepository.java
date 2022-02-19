package es.fp.restfull.evento.modelo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import es.fp.restfull.evento.modelo.entitybeans.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

	
	@Query("SELECT sum(r.cantidad) FROM Reserva r WHERE r.evento.idEvento = ?1")
	public Integer buscarPlazas(int idEvento);
	
	
}
