package com.eventos.daos;

import com.eventos.beans.Reserva;

import java.util.List;

public interface IntReservaDao {
	List<Reserva> findAll();
	List<Reserva> reservasUsuario(int idUsuario);
	Reserva buscarReserva(int idUsuario, int idEvento);
	int altaReserva(Reserva reserva);
	boolean verificarEntradas(int cant, int idres, int idEvento);
}
