package es.fp.restfull.evento.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fp.restfull.evento.modelo.dao.EventoDao;
import es.fp.restfull.evento.modelo.dao.ReservasDao;
import es.fp.restfull.evento.modelo.entitybeans.Evento;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest/eventos")
public class EventoRestController {

	@Autowired
	private EventoDao edao;
	
	@Autowired
	private ReservasDao rdao;
	
	@GetMapping("/todos")
	public List<Evento> eveTodos(){
		return edao.findAll();
	}
	
	@GetMapping("/activos")
	public List<Evento> eveActi(){
		return edao.verActivos();
	}
	
	@GetMapping("/destacados")
	public List<Evento> eveDest(){
		return edao.verDestacados();
	}
	
	@GetMapping("/buscarEventos/{dato}")
	public  List<Evento> verPor(@PathVariable("dato") String dato) {
		return edao.buscarEvento(dato);
	}
	
	@GetMapping("/plazasQuedan/{idEvento}")
	public Map<String, Integer> verEntradas(@PathVariable("idEvento") int idEvento) {
		HashMap<String, Integer> map = new HashMap<>();
		
		int plazasocupadas =rdao.buscarPlazas(idEvento);
		int plazastotales = edao.verUno(idEvento).getAforoMaximo();
		int plazasquedan = plazastotales-plazasocupadas;
		if(plazasquedan <= 0)
			plazasquedan=0;
		
		map.put("plazas_quedan", plazasquedan);
		
		return map;
	}
	
	@GetMapping("/verUno/{idEvento}")
	public Evento verEve(@PathVariable("idEvento") int idEvento) {
		return edao.verUno(idEvento);	
	}
	
	@PostMapping("/alta")
	public String procAlta(@RequestBody Evento evento) {
		return (edao.insertar(evento) == 1)?"Alta realizada":"Alta NO realizada";
	}
	
	@PutMapping("/modificar")
	public String procModi(@RequestBody Evento evento) {
		return (edao.modificar(evento) == 1)?"Modificacion realizada":"Modificacion NO realizada";
	}
	
	@DeleteMapping("/eliminar/{idEvento}")
	public String procEli(@PathVariable("idEvento") int idEvento) {
		return (edao.eliminar(idEvento) == 1)?"Eliminacion realizada":"Eliminacion NO realizada";
	}
}
