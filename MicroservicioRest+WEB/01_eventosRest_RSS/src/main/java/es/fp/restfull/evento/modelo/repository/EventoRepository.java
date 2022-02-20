package es.fp.restfull.evento.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.fp.restfull.evento.modelo.entitybeans.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
		
	@Query("select e from Evento e where e.tipo.idTipo = ?1")
	public List<Evento> buscarPorTipo(int idTipo);

	@Query("select e from Evento e where e.estado = 'Activo'")//SELECT * FROM eventos_spring_boot.eventos where estado = 'Activo';
	public List<Evento> buscarActivos();
	
	@Query("select e from Evento e where e.destacado = 'A'")//SELECT * FROM eventos_spring_boot.eventos where DESTACADO = 'A';
	public List<Evento> buscarDestacados();
	
	@Query("select e from Evento e where e.nombre like %?1%")//SELECT * FROM eventos_spring_boot.eventos where NOMBRE  LIKE '%Bod%';
	public List<Evento> buscarEvento(String dato);
	
}