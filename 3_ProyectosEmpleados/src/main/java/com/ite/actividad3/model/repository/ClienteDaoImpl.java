package com.ite.actividad3.model.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Cliente;

@Repository
public class ClienteDaoImpl implements IntClienteDao{

	List<Cliente> lista;
	
	public ClienteDaoImpl() {
		lista = new ArrayList<Cliente>();
		cargarDatos();
	}
	/**
	 * Devuelve la lista con todos los clientes
	 */
	@Override
	public List<Cliente> findAll() {
	
		return lista;
	}

	/**
	 * @param Recibe como parámetro el cif del cliente y devuelve
	 * el objeto cliente que buscamos
	 */
	@Override
	public Cliente findById(String cif) {
		Cliente aux = new Cliente();
		aux.setCif(cif);
		int pos= lista.indexOf(aux);
		
		if(pos==-1)
			return null;
		else
			return ((lista.get(pos)!=null)?lista.get(pos):null);
	}
	
	/**
	 * @param Recibe como parámetro el objeto cliente que queremos dar de alta
	 * Si podemos realizar el alta devuelve 1, en caso contrario devuelve 0.
	 */
	@Override
	public int altaCliente(Cliente cliente) {
		
		return (lista.contains(cliente)?0:(lista.add(cliente))?1:0);
	}

	/**
	 * @param Recibe como parámetro el cif del cliente que queremos editar
	 * Si se puede editar devuelve 1, en caso contrario devuelve 0
	 */
	@Override
	public int editaCliente(String cif) {
		Cliente aux = new Cliente();
		aux.setCif(cif);
		int pos = lista.indexOf(aux);
		
		if(pos == -1)
			return 0;
		else			
			return (lista.set(pos, aux)!=null)?1:0;
	}

	/**
	 * 
	 * @param cif
	 * @return Devuelve 1 si la baja se ha realizado correctamente, 0 en caso contrario.
	 */
	@Override
	public int bajaCliente(String cif) {
		Cliente aux = new Cliente();
		aux.setCif(cif);
		
		return lista.contains(aux)?(lista.remove(aux)?1:0):0;
	}
	
	
	//Método para cargar datos de testeo
	private void cargarDatos(){
		
		lista.add(new Cliente("A7778001", "Industrias Ahora", "Madrid",BigDecimal.valueOf(4500000L), 350));
		lista.add(new Cliente("A6668002", "Aguazul", "Sevilla",BigDecimal.valueOf(1250000L), 124));
		lista.add(new Cliente("A5558003", "Marismeños", "Cadiz",BigDecimal.valueOf(850000L), 35));
		
		
	}

}
