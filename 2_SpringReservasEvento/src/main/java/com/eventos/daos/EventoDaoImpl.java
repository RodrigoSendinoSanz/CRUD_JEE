package com.eventos.daos;

import com.eventos.beans.Evento;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EventoDaoImpl implements IntEventoDao {
    private List<Evento> lista;
    private List<Evento> lista_aux;

    public EventoDaoImpl() {
        lista = new ArrayList<>();
        lista_aux = new ArrayList<>();
        cargarDatos();
    }

    public void cargarDatos() {
        lista.add(new Evento(1, "Concierto Rullo y la contrabanda", new Date(), 5, "C. de Hortaleza, 63, 28004 Madrid", "Activo", "No", 780, 40, 45));
        lista.add(new Evento(2, "BODA DE FRANCISCO ZOILO", new Date(), 5, "Calle Nunca jamas, 1", "Cancelado", "Si", 412,80, 95));
        lista.add(new Evento(3, "Concierto Dj Asus", new Date(), 5, "C. de Hortaleza, 63, 28004 Madrid", "Activo", "Si", 320, 70, 78));
        lista.add(new Evento(4, "Concierto Fito y los fitipaldis", new Date(), 5, "Calle Fenado Rojas , 1", "Activo", "No", 450, 90, 74));
        lista.add(new Evento(5, "BODA DE FRANCISCO TARREGA", new Date(), 5, "C. de Hortaleza, 63, 28004 Madrid", "Cancelado", "Si",470, 30, 79));
    }


    @Override
    public Evento findById(int idEvento) {
        for (Evento evento : lista) {
            if (evento.getIdEvento() == idEvento) {
                return evento;
            }
        }
        return null;
    }


    @Override
    public List<Evento> findAll() {
        return lista;
    }


    public List<Evento> findActivos() {
        lista_aux.clear();
        for (Evento evento : lista) {
            if (evento.getEstado().equals("Activo")) {
                lista_aux.add(evento);
            }
        }
        return lista_aux;
    }


    public List<Evento> findDestacados() {
        lista_aux.clear();
        for (Evento evento : lista) {
            if (evento.getDestacado().equals("Si")) {
                lista_aux.add(evento);
            }
        }
        return lista_aux;
    }
}
