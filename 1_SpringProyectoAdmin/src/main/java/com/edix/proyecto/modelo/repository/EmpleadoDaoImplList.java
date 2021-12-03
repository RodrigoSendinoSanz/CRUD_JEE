package com.edix.proyecto.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyecto.modelo.beans.Empleado;




@Repository 
public class EmpleadoDaoImplList implements IntEmpladoDao{

	private List<Empleado> lista;
	private static int idEmpleadoAuto;
	
	public EmpleadoDaoImplList() {
		lista = new ArrayList<Empleado>();
		cargar();
	}
	
	private void cargar() {
		IntPerfilesDao iper = new PerfilesDaoImplList();
		
		lista.add(new Empleado(1, "Jose", "josejuan@gmail.com", "12345", new BigDecimal("1700.20"), new Date(), new Date(), iper.findById(1), null));
		lista.add(new Empleado(2, "Ana", "anamarin@gmail.com", "ana123", new BigDecimal("1200.20"), new Date(), new Date(), iper.findById(2), null));
		lista.add(new Empleado(3, "Pepe", "pepe12@gmail.com", "pepe123", new BigDecimal("1300.20"), new Date(), new Date(), iper.findById(3), null));
		
		idEmpleadoAuto=4;
	}

	@Override
	public int comprobarLogin(int idEmpl, String correo, String password) {
		System.out.println(idEmpl);
		System.out.println(correo);
		System.out.println(password);

		for (Empleado ele : this.findAll()) {
			System.out.println("Id empleado "+ele.getIdEmpl());
			System.out.println("Perfil empleado "+ele.getPerfile().getIdPerfil());
			if(ele.getIdEmpl() == idEmpl &&ele.getCorreo().equals(correo)&&ele.getPassword().equals(password)&&ele.getPerfile().getIdPerfil()==1)
				return 2;
			if(ele.getIdEmpl() == idEmpl &&ele.getCorreo().equals(correo)&&ele.getPassword().equals(password)&&ele.getPerfile().getIdPerfil()==2)
				return 1;
			if(ele.getIdEmpl() == idEmpl &&ele.getCorreo().equals(correo)&&ele.getPassword().equals(password)&&ele.getPerfile().getIdPerfil()==3)
				return 1;
		}
		return 0;
	} 



	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return lista;
	
	}

	@Override
	public Empleado findById(int idEmpl) {
		Empleado empleado = new Empleado();
		empleado.setIdEmpl(idEmpl);
		int pos = lista.indexOf(empleado);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}



}
