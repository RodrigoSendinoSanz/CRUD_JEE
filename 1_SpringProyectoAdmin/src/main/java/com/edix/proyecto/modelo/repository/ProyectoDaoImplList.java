package com.edix.proyecto.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyecto.modelo.beans.Empleado;
import com.edix.proyecto.modelo.beans.Proyecto;


@Repository 
public class ProyectoDaoImplList implements IntProyectoDao{

	private List<Proyecto> lista;
	private static int idProyectoAuto;
	
	public ProyectoDaoImplList() {
		lista = new ArrayList<Proyecto>();
		cargar();
	}
	
	private void cargar() {
		IntEmpladoDao edao = new EmpleadoDaoImplList();
		IntClienteDao cdao = new ClienteDaoImplList();
			lista.add(new Proyecto(1, new BigDecimal("17200.20"), new BigDecimal("17500.20"), "Proyecto a sobre coches", "ACTIVO", new Date(), new Date(), new Date(), new BigDecimal("118500.20"), cdao.findById("23729390P"), edao.findById(1)));
			lista.add(new Proyecto(2, new BigDecimal("16000.20"), new BigDecimal("14500.20"), "Proyecto a sobre motos", "DESACTIVADO", new Date(), new Date(), new Date(), new BigDecimal("13400.20"), cdao.findById("23729322P"), edao.findById(2)));
			lista.add(new Proyecto(3, new BigDecimal("18550.20"), new BigDecimal("17500.20"), "Proyecto a sobre aviones", "ACTIVO", new Date(), new Date(), new Date(), new BigDecimal("103400.20"), cdao.findById("12349390P"), edao.findById(3)));
			lista.add(new Proyecto(4, new BigDecimal("156460.20"), new BigDecimal("1789560.20"), "Proyecto a sobre motores", "ACTIVO", new Date(), new Date(), new Date(), new BigDecimal("108500.20"), cdao.findById("23729322P"), edao.findById(3)));
			lista.add(new Proyecto(5, new BigDecimal("141500.20"), new BigDecimal("17450.20"), "Proyecto a sobre Aerodinamica", "DESACTIVADO", new Date(), new Date(), new Date(), new BigDecimal("1156500.20"), cdao.findById("12349390P"), edao.findById(2)));
			
			idProyectoAuto=5;
	}
	

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public int altaProyecto(Proyecto proyecto) {
		if (lista.contains(proyecto))
			return 1;
		else {
			proyecto.setIdProyecto(lista.size() + 1);
			lista.add(proyecto);
			return 0;
		}
	}
	

	@Override
	public Proyecto findById(int idProyecto) {
		Proyecto proyecto = new Proyecto();
		proyecto.setIdProyecto(idProyecto);
		System.out.println(lista);
		int pos = lista.indexOf(proyecto);
		if(pos == -1)
			return null;
		else
			return lista.get(pos);
	}
	

	@Override
	public int terminarProyecto(int idProyecto) {
		Proyecto proyecto = findById(idProyecto);
		int pos = lista.indexOf(proyecto);

		if(pos == -1) {
			System.out.println("ahora por aqui no");

			return 0;
		}else {
			System.out.println("pasando por terminar if-1");
			System.out.println(proyecto.getJefeProyecto().getNombre());
			proyecto.setEstado("TERMINADO");
			proyecto.setCosteReal(new BigDecimal("000000"));
			return 1;
		}
	}
		
	
	
	
	}
