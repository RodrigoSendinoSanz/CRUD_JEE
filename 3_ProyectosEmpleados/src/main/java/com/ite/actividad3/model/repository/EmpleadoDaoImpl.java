package com.ite.actividad3.model.repository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Empleado;
import com.ite.actividad3.model.beans.Proyecto;
import com.ite.actividad3.model.beans.ProyectoConEmpleado;


@Repository
public class EmpleadoDaoImpl implements IntEmpleadoDao {
	
	private List<Empleado> lista;
	
	public EmpleadoDaoImpl() {
		lista = new ArrayList<Empleado>();
		
		cargarDatos();	
	}
	
	

	/**
	 * Devuelve la lista de los empleados
	 */
	@Override
	public List<Empleado> findAll() {
		
		return lista;
	}

	/**
	 * @param Recibe el id del empleado y devuelve un objeto de tipo Empleado
	 * con el empleado.
	 */
	@Override
	public Empleado findById(int idEmpl) {
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);
		
		if(pos == -1)
			return null;
		else
			return (lista.get(pos) != null)?lista.get(pos):null;
	}

	/**
	 * @param Recibe un objeto de tipo empleado.
	 * Si puede realizar el lata devuelve 1, en caso contrario devuelve 0.
	 */
	@Override
	public int altaEmpleado(Empleado empleado) {
		
		return (lista.add(empleado))?1:0;
	}

	/**
	 * @param Recibe el id del empleado
	 * Devuelve el objeto con el empleado
	 */
	@Override
	public int editarEmpleado(int idEmpl) {
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);
		
		if(pos == -1)
			return 0;
		else
			return (lista.set(pos, aux)!=null)?1:0;
	}

	/**
	 * @param Recibe el id del empleado
	 * Elmina de la lista el Empleado
	 */
	@Override
	public int borrarEmpleado(int idEmpl) {
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);
		
		if(pos == -1)
			return 0;
		else
			return (lista.remove(pos)!=null)?1:0;
	}
	
	/**
	 * @return Devuelve el id que se asigna automáticamente a un
	 * nuevo empleado
	 */
	@Override
	public int asignaId() {
		
		return lista.size()+1;
	}
	
	@Override
	public List<Empleado> mostrarJefes() {
		List<Empleado> jefes = new ArrayList<Empleado>();
		
		for(Empleado e: lista) {
			if(e.getPerfile().getIdPerfil() == 2)
				jefes.add(e);
		}
		return jefes;
	}
	
	
	//Método para cargar datos de prueba
	private void cargarDatos() {
		IntDepartamentoDao idDep = new DepartamentoDaoImpl();
		IntPerfileDao idPerf = new PerfileDaoImpl();	
		
		String fechaArray[] = {"1975-03-27", "2020-12-01", "1990-05-10", "2020-12-01", "1980-06-15",
				"2020-12-01", "1975-10-12", "2020-12-01", "2000-06-27", "2021-02-28",
				"1975-03-27", "2020-12-01", "1990-05-10", "2020-12-01", "1980-06-15",
				"2020-12-01", "1975-10-12", "2020-12-01", "2000-06-27", "2021-02-28"};
		
		SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
		Date fecha[] = {new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				new Date(),new Date(),new Date()};
		
		try {
			for(int i=0; i<fechaArray.length; i++) {
				fecha[i] = sdf.parse(fechaArray[i]);
			}
		}catch (ParseException pe) {System.out.println("La excepción es: " + pe);}
		
		
		lista.add(new Empleado(100, "Esteban", "esteban@ite.com", "1234", fecha[0], fecha[1], 
				BigDecimal.valueOf(80000), idDep.findById(10), idPerf.findById(4)));
		lista.add(new Empleado(200, "Raquel", "raquel@ite.com", "1234", fecha[2], fecha[3], 
				BigDecimal.valueOf(32000), idDep.findById(20), idPerf.findById(1)));
		lista.add(new Empleado(114, "Tomas", "tomas@ite.com", "1234", fecha[2], fecha[3], 
				BigDecimal.valueOf(45000), idDep.findById(30), idPerf.findById(2)));
		lista.add(new Empleado(115, "Eva", "eva@ite.com", "1234", fecha[4], fecha[5], 
				BigDecimal.valueOf(52000), idDep.findById(30), idPerf.findById(2)));
		lista.add(new Empleado(116, "Laura", "laura@ite.com", "1234", fecha[6], fecha[7], 
				BigDecimal.valueOf(30000), idDep.findById(30), idPerf.findById(2)));
		lista.add(new Empleado(117, "Rafael", "rafael@ite.com", "1234", fecha[8], fecha[9],
				BigDecimal.valueOf(15000), idDep.findById(30), idPerf.findById(3)));
		lista.add(new Empleado(118, "Sara", "sara@ite.com", "1234", fecha[10], fecha[11], 
				BigDecimal.valueOf(15000), idDep.findById(30), idPerf.findById(3)));
		lista.add(new Empleado(119, "Alicia", "alicia@ite.com", "1234", fecha[12], fecha[13], 
				BigDecimal.valueOf(15000), idDep.findById(30), idPerf.findById(3)));
		lista.add(new Empleado(120, "Gemma", "gemma@ite.com", "1234", fecha[14], fecha[15], 
				BigDecimal.valueOf(15000), idDep.findById(30), idPerf.findById(3)));
		lista.add(new Empleado(121, "Teresa", "teresa@ite.com", "1234", fecha[16], fecha[17], 
				BigDecimal.valueOf(15000), idDep.findById(30), idPerf.findById(3)));
		lista.add(new Empleado(122, "Miguel", "miguel@ite.com", "1234", fecha[18], fecha[19],
				BigDecimal.valueOf(1500), idDep.findById(30), idPerf.findById(3)));
	}



	@Override
	public List<Empleado> operativosSinAsignarAProyectos() {
		IntProyectoConEmpleadosDao pcedao = new ProyectoConEmpleadoDaoImpl();
		List<Empleado> operativos = this.findOperativos();
		List<Empleado> sinAsignar = new ArrayList<Empleado>();
		
		
		boolean existe = false;
		
		for (Empleado empl: operativos) {
			existe = false;
			for (ProyectoConEmpleado pce: pcedao.listaEmpleadosAsignados()) {
				if(pce.getEmpleado().getIdEmpl() == empl.getIdEmpl()) {
					existe=true;
					break;
				}
			}
			if (!existe)
				sinAsignar.add(empl);
		}
		
		return sinAsignar;
	}



	@Override
	public List<Empleado> findOperativos() {
		List<Empleado> aux = new ArrayList<Empleado>();
		for (Empleado ele: lista) {
			if (ele.getPerfile().getIdPerfil() == 3) {
				aux.add(ele);
			}
		}
		return aux;
	}



	@Override
	public Empleado findByIdEmplAndCorreoAndPassword(int idEmpl, String correo, String password) {
		Empleado empleado = this.findById(idEmpl);
		if (empleado != null) {
			if(empleado.getCorreo().equals(correo) && empleado.getPassword().equals(password))
				return empleado;
		}
		return null;
	}



	
	
	
}
