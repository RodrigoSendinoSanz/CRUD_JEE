package com.edix.proyecto.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyecto.modelo.beans.Cliente;
import com.edix.proyecto.modelo.beans.Empleado;



@Repository 
public class ClienteDaoImplList implements IntClienteDao{
	
	private List<Cliente> lista;

	
	public ClienteDaoImplList() {
		lista = new ArrayList<Cliente>();
		cargar();
	}

	private void cargar() {

		lista.add(new Cliente("23729390P", "Calle Juan 13 2 B",  new BigDecimal("140500.20"), "AutocaresRamirez.S.L", 27));
		lista.add(new Cliente("12349390P", "Calle Alfonso 12  Bajo",  new BigDecimal("10500.20"), "TaxiSport.S.L", 17));
		lista.add(new Cliente("23729322P", "Calle Maria 323 4 B",  new BigDecimal("1449500.20"), "Uber.S.L", 204));

	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return lista;
	
	}


	@Override
	public Cliente findById(String cif) {
		Cliente cliente = new Cliente();
		cliente.setCif(cif);
		int pos = lista.indexOf(cliente);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}
}
