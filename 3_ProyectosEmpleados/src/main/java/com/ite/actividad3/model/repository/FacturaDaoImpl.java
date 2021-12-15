package com.ite.actividad3.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Factura;

@Repository
public class FacturaDaoImpl implements IntFacturaDao{

	List<Factura> lista;
	
	public FacturaDaoImpl() {
		lista = new ArrayList<Factura>();
	}
	/**
	 * Devuelve la lista con todas las Facturas
	 */
	@Override
	public List<Factura> findAll() {
	
		return lista;
	}

	/**
	 * @param Recibe como parámetro el número de factura
	 * @return el objeto factura que buscamos
	 */
	@Override
	public Factura findById(String idFactura) {
		Factura aux = new Factura();
		aux.setIdFactura(idFactura);
		int pos= lista.indexOf(aux);
		
		if(pos==-1)
			return null;
		else
			return ((lista.get(pos)!=null)?lista.get(pos):null);
	}
	
	/**
	 * @param Recibe como parámetro el objeto factura que queremos dar de alta
	 * @return Si podemos realizar el alta devuelve 1, en caso contrario devuelve 0.
	 */
	@Override
	public int altaFactura(Factura factura) {
		
		return (lista.contains(factura)?0:(lista.add(factura))?1:0);
	}

	/**
	 * @param Recibe como parámetro el numero de factura que queremos editar
	 * @return Si se puede editar devuelve 1, en caso contrario devuelve 0
	 */
	@Override
	public int editaFactura(String idFactura) {
		Factura aux = new Factura();
		aux.setIdFactura(idFactura);
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
	public int bajaFactura(String idFactura) {
		Factura aux = new Factura();
		aux.setIdFactura(idFactura);
		
		return lista.contains(aux)?(lista.remove(aux)?1:0):0;
	}

}
