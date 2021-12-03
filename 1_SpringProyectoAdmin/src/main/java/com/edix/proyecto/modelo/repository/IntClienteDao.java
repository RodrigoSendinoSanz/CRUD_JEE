package com.edix.proyecto.modelo.repository;

import java.util.List;

import com.edix.proyecto.modelo.beans.Cliente;

public interface IntClienteDao {

	List<Cliente> findAll();

	Cliente findById(String cif);

}
