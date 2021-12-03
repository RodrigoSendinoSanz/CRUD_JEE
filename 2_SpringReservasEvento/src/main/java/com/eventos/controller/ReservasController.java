package com.eventos.controller;

import com.eventos.beans.Reserva;
import com.eventos.beans.Usuario;
import com.eventos.daos.IntEventoDao;
import com.eventos.daos.IntReservaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/reservas")
public class ReservasController {

	@Autowired
	private IntReservaDao reservaDao;

	@Autowired
	private IntEventoDao eventoDao;


	@GetMapping("/detalle")
	public String detalle(Model model, HttpServletRequest request) {
		if (request.getSession(false) == null)
			return "redirect:/usuario/";
		else if (request.getSession().getAttribute("usuarioSesion") == null)
			return "redirect:/usuario/";
		else {
			Usuario idUsu = (Usuario) request.getSession().getAttribute("usuarioSesion");
			model.addAttribute("reservas", reservaDao.reservasUsuario(idUsu.getIdUsuario()));
			return "listarReservas";
		}
	}


	@GetMapping("/reserva/{idEvento}")
	public String reserva(Model model, @PathVariable("idEvento") int idEvento, HttpServletRequest request) {

		if (request.getSession(false) == null)
			return "redirect:/usuario/";
		else if (request.getSession().getAttribute("usuarioSesion") == null)
			return "redirect:/usuario/";
		else {
			Usuario idUsu = (Usuario) request.getSession().getAttribute("usuarioSesion");

			model.addAttribute("evento", eventoDao.findById(idEvento));
			model.addAttribute("reservaUsu", reservaDao.buscarReserva(idUsu.getIdUsuario(), idEvento));
			return "reservasDetalle";
		}
	}


	@PostMapping("/verificarpedido/{idEvento}")
	public String verficar(@RequestParam("cantidadEntradas") int cantEnt, @PathVariable("idEvento") int idEvento,
			RedirectAttributes rattr, HttpServletRequest request) {

		if (cantEnt > 0) {
			
			Usuario user = (Usuario) request.getSession().getAttribute("usuarioSesion");

			if (reservaDao.buscarReserva(user.getIdUsuario(), idEvento) == null) {
				reservaDao.altaReserva(
						new Reserva(idEvento, user.getIdUsuario(), eventoDao.findById(idEvento).getPrecio(), "", 0));
			}

			Reserva reserva = reservaDao.buscarReserva(user.getIdUsuario(), idEvento);
			
			if (reservaDao.verificarEntradas(cantEnt, reserva.getIdReserva(), idEvento)) {
				reserva.setCantidad(reserva.getCantidad() + cantEnt);
				rattr.addFlashAttribute("mensaje_compra", "Reservado correctamente");
			} else
				rattr.addFlashAttribute("mensaje_compra", "No te quedan tantas entradas.");
		} else {
			rattr.addFlashAttribute("mensaje_compra", "No puedes introducir numeros negativos.");
		}
		return "redirect:/reservas/reserva/" + idEvento;
	}
}
