package com.ite.actividad3.model.repository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Proyecto;
import com.ite.actividad3.model.beans.ProyectoConEmpleado;

@Repository
public class ProyectoDaoImpl implements IntProyectoDao{

	private List<Proyecto> lista;
	
	public ProyectoDaoImpl() {
		lista = new ArrayList<Proyecto>();
		
		cargarDatos();
	}
	/**
	 * Devuelve la lista con todos los proyectos
	 */
	@Override
	public List<Proyecto> findAll() {
	
		return lista;
	}

	/**
	 * @param Recibe como parámetro el numero de proyecto
	 * @return El objeto proyecto que buscamos
	 */
	@Override
	public Proyecto findById(String idProyecto) {
		Proyecto aux = new Proyecto();
		aux.setIdProyecto(idProyecto);
		int pos= lista.indexOf(aux);
		
		if(pos==-1)
			return null;
		else
			
			return ((lista.get(pos)!=null)?lista.get(pos):null);
	}
	
	/**
	 * @param Recibe como parámetro el objeto proyecto que queremos dar de alta
	 * @return Si podemos realizar el alta devuelve 1, en caso contrario devuelve 0.
	 */
	@Override
	public int altaProyecto(Proyecto proyecto) {
		proyecto.setEstado("Activo");
		
		return (lista.contains(proyecto)?0:(lista.add(proyecto))?1:0);
	}

	/**
	 * @param Recibe como parámetro el numero de proyecto que queremos editar
	 * @return Si se puede editar devuelve 1, en caso contrario devuelve 0
	 */
	@Override
	public int editaProyecto(Proyecto proyecto) {
		
		int pos = lista.indexOf(proyecto);
		
		if(pos == -1)
			return 0;
		else			
			return (lista.set(pos, proyecto)!=null)?1:0;
	}

	/**
	 * 
	 * @param Recibe como parametro el numero de proyecto que queremos dar de baja
	 * @return Devuelve 1 si la baja se ha realizado correctamente, 0 en caso contrario.
	 */
	@Override
	public int bajaProyecto(Proyecto proyecto) {
		
		return lista.contains(proyecto)?(lista.remove(proyecto)?1:0):0;
	}
	
	/**
	 * @return Devuelve una lista con los proyectos activos-
	 */
	@Override
	public List<Proyecto> muestraActivos() {
		List<Proyecto> listaActivos = new ArrayList<Proyecto>();
		
		for(Proyecto pro: lista) {
			if(pro.getEstado().equalsIgnoreCase("activo"))
				listaActivos.add(pro);
		}
		return listaActivos;
	}
	
	/**
	 * @return Devuelve una lista con los proyectos activos-
	 */
	@Override
	public List<Proyecto> muestraTerminados() {
		List<Proyecto> listaTerminados = new ArrayList<Proyecto>();
		
		for(Proyecto pro: lista) {
			if(pro.getEstado().equalsIgnoreCase("terminado"))
				listaTerminados.add(pro);
		}
		return listaTerminados;
	}
	
	/**
	 * @return Devuelve una lista con los proyectos activos del usuario
	 * que se pasa por id y que sea Jefe
	 */
	@Override
	public List<Proyecto> proyActivosPorJefe(int idEmpl) {
		List<Proyecto> lpaj = new ArrayList<Proyecto>();
		
		for(Proyecto proy: lista) {
			if(proy.getJefeProyecto().getIdEmpl() == idEmpl && proy.getEstado().equalsIgnoreCase("activo"))
				lpaj.add(proy);
		}
		return lpaj;
	}
	
	//Metodo para meter datos de testeo
	private void cargarDatos() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2021-09-30";
		String dateInString2= "2022-09-30";
		Date fechaInicio=new Date();
		Date fechaFin = new Date();
		try {
			fechaInicio = sdf.parse(dateInString);
			fechaFin = sdf.parse(dateInString2);
		}catch(ParseException pe) {System.out.println("La excepción es "+pe);}
		
		IntClienteDao iCliente = new ClienteDaoImpl();
		IntEmpleadoDao iEmpl = new EmpleadoDaoImpl();
		
		lista.add(new Proyecto("HJ0001", "Licencias Corporativas ", "Activo", fechaInicio, fechaFin, BigDecimal.valueOf(500000L), 
				BigDecimal.valueOf(250000L), iCliente.findById("A7778001"), iEmpl.findById(114)));
		lista.add(new Proyecto("HJ0002", "Formacion Habilidades Dirección", "Activo", fechaInicio, fechaFin, BigDecimal.valueOf(500000L),
				BigDecimal.valueOf(250000L), iCliente.findById("A7778001"), iEmpl.findById(114)));
		lista.add(new Proyecto("HJ0003", "Consultoría de Procesos", "Activo", fechaInicio, fechaFin, BigDecimal.valueOf(500000L),
				BigDecimal.valueOf(250000L), iCliente.findById("A7778001"), iEmpl.findById(114)));
		lista.add(new Proyecto("HJ0004", "Formación Jefes de Proyectos", "Activo", fechaInicio, fechaFin, BigDecimal.valueOf(500000L),
				BigDecimal.valueOf(250000L), iCliente.findById("A6668002"), iEmpl.findById(115)));
		lista.add(new Proyecto("HJ0005", "Formacion Talento", "Activo", fechaInicio, fechaFin, BigDecimal.valueOf(500000L),
				BigDecimal.valueOf(250000L), iCliente.findById("A6668002"), iEmpl.findById(115)));
		lista.add(new Proyecto("HJ0006", "Consultoria de productos", "Activo", fechaInicio, fechaFin, BigDecimal.valueOf(500000L),
				BigDecimal.valueOf(250000L), iCliente.findById("A6668002"), iEmpl.findById(115)));
		
	}
	@Override
	public Proyecto asignarEmpleadosAProyecto(String idProyecto) {
		IntProyectoConEmpleadosDao pcedao = new ProyectoConEmpleadoDaoImpl();
		Proyecto proyecto = this.findById(idProyecto);
		proyecto.setProyectoConEmpleados(pcedao.listaEmpleadosAsignadosAProyecto(idProyecto));
		return proyecto;
	}
	
	

}
