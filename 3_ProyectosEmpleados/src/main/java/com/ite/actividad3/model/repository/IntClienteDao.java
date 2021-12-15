package com.ite.actividad3.model.repository;

import java.util.List;


import com.ite.actividad3.model.beans.Cliente;

public interface IntClienteDao {

	List<Cliente> findAll(); //Devuelve una lista con todos los clientes
	Cliente findById(String cif); //Devuelve el cliente
	int altaCliente(Cliente cliente); //Da de alta un cliente
	int editaCliente(String cif); //Edita un cliente
	int bajaCliente (String cif); //Da de baja un cliente
}
