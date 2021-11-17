package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.dao.EventoListImpl;
import modelo.dao.IntEventoDao;
import modelo.dao.IntTipoDao;
import modelo.dao.TipoListImpl;




/**
 * Servlet implementation class GestionEventos
 */
@WebServlet(description = "tareas asociadas a productos", urlPatterns = { "/eventos" })
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("entrando en intit");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entrando en gestion eventos en servlet");
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "activos":
			procActivos( request,  response);
				
			break;
			
		case "alta":
			procAlta (request,  response);
			System.out.println("Case alta");
			
		break;

		case "editar":
			procEditar( request,  response);
			break;
			
		case "eliminar":
			procEliminar( request,  response);
			System.out.println("Case editar");
			
		break;
		case "cancelar":
			procCancelar( request,  response);
			System.out.println("Case cancelar");
			
		break;
		default:
			System.out.println("Opcion incorrecta: " + opcion);
			break;
		}
	}

	protected void procActivos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("activos.jsp").forward(request, response);
	}
	
	protected void procAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Evento> listaalt = (List<Evento>) request.getSession().getAttribute("listarEventos");
        if(listaalt == null) {
        	listaalt = new ArrayList<Evento>();
        }

        Evento ax = new Evento();
        ax = listaalt.get(listaalt.size()-1);
        int nv= ax.getId_evento()+1;

        Evento event = new Evento();
        Tipo tip = new Tipo();

        event.setId_evento((int) nv);
        event.setNombre(request.getParameter("nombre"));
        event.setPrecio(Integer.parseInt(request.getParameter("precio")));
        event.setDescripcion(request.getParameter("descripcion"));
        event.setFecha_inicio(request.getParameter("fecha_inicio"));
        event.setDuracion(Integer.parseInt(request.getParameter("duracion")));
        event.setDireccion(request.getParameter("direccion"));
        event.setEstado(request.getParameter("estado"));
        event.setDestacado(request.getParameter("destacado"));
        event.setAforo_maximo(Integer.parseInt(request.getParameter("aforo_maximo")));
        event.setMinimo_asistencia(Integer.parseInt(request.getParameter("minimo_asistencia")));
        event.setId_tipo(tip);
        System.out.println(event);
        listaalt.add(event);
        request.getSession().setAttribute("listarEventos", listaalt);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        System.out.println(event);
		
	}
	
	protected void procEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("en editar id :"+ request.getParameter("id"));
			int id = Integer.parseInt(request.getParameter("id"));
			IntEventoDao ievent = new EventoListImpl();
			Evento evento = ievent.findById(id);

			request.getSession().setAttribute("evento", evento);
			request.getRequestDispatcher("EditarEvento.jsp").forward(request, response);
		

	}
	
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("en eliminar id :"+ request.getParameter("id"));
		List <Evento> lista = (List<Evento>)request.getSession().getAttribute("listarEventos");
		int id =(Integer.parseInt(request.getParameter("id")));
		
		Evento aux = new Evento();
		aux.setId_evento(id);
		int pos = lista.indexOf(aux);
		if (pos != -1) {
			lista.remove(pos);
			request.getSession().setAttribute("listarEventos", lista);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	
	protected void procCancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("en cancelar:"+ request.getParameter("id"));
			
		List<Evento> listacan = (List<Evento>) request.getSession().getAttribute("listarEventos");
		int idcan = (Integer.parseInt(request.getParameter("id")));
		Evento aux = new Evento();
		aux.setId_evento(idcan);
		int pos = listacan.indexOf(aux);
		
		if(pos != -1) {
			aux = listacan.get(pos);
			aux.setEstado("cancelado");
			listacan.set(pos, aux);
			request.getSession().setAttribute("listaeventos", listacan);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
}
