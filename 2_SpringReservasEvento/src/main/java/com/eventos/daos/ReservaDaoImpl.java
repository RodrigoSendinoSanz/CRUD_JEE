package com.eventos.daos;

import com.eventos.beans.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservaDaoImpl implements IntReservaDao {
	private List<Reserva> lista;
	private List<Reserva> lista_aux;

	public ReservaDaoImpl() {
		lista = new ArrayList<>();
		lista_aux = new ArrayList<>();
		cargarDatos();
	}

	public void cargarDatos() {
	}


	@Override
	public List<Reserva> findAll() {
		return lista;
	}


	public List<Reserva> reservasUsuario(int idUsuario) {
		lista_aux.clear();
		for (Reserva reserva : lista) {
			if (reserva.getIdUsuario() == idUsuario) {
				lista_aux.add(reserva);
			}
		}
		return lista_aux;
	}


	public Reserva buscarReserva(int idUsuario, int idEvento) {
		for (Reserva reserva : lista) {
			if (reserva.getIdUsuario() == idUsuario && reserva.getIdEvento() == idEvento) {
				return reserva;
			}
		}
		return null;
	}


	public int altaReserva(Reserva reserva) {
		if (lista.contains(reserva))
			return 1;
		else {
			reserva.setIdReserva(lista.size() + 1);
			lista.add(reserva);
			return 0;
		}
	}


	public boolean verificarEntradas(int cant, int idres, int idEvento) {
		boolean veri = false;

		for (Reserva reserva : lista) {
			if (reserva.getIdReserva() == idres && reserva.getIdEvento() == idEvento) {
				if (10 >= (reserva.getCantidad() + cant)) {
					veri = true;
					break;
				}
			}
		}

		return veri;
	}

}
