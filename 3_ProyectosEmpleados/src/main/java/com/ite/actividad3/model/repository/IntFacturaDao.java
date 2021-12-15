package com.ite.actividad3.model.repository;

import java.util.List;


import com.ite.actividad3.model.beans.Factura;

public interface IntFacturaDao {

	List<Factura> findAll(); //Devuelve una lista con todas las facturas
	Factura findById(String idFactura); //Devuelve la factura
	int altaFactura(Factura factura); //Da de alta una factura
	int editaFactura(String idFactura); //Edita una factura
	int bajaFactura (String idFactura); //Da de baja una factura
}
