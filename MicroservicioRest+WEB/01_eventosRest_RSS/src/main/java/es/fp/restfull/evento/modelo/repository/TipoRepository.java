package es.fp.restfull.evento.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fp.restfull.evento.modelo.entitybeans.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer>{

}
