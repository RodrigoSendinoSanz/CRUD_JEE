package com.ite.actividad3.model.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.actividad3.model.beans.Producto;

@Repository
public class ProductoDaoImpl implements IntProductoDao{

	List<Producto> lista;
	
	public ProductoDaoImpl() {
		lista = new ArrayList<Producto>();
		cargarDatos();
	}
	
	/**
	 * @return la lista con todos los productos
	 */
	@Override
	public List<Producto> findAll() {
		return lista;
	}

	/**
	 * @param int Recibe el id del producto
	 * @return Objeto de tipo producto con el producto que buscamos, en caso contrio, null
	 */
	@Override
	public Producto findById(int idproducto) {
		Producto aux = new Producto();
		aux.setIdProducto(idproducto);
		int pos = lista.indexOf(aux);
		
		if(pos ==-1)
			return null;
		else
			return (lista.get(pos)!=null)?lista.get(pos):null;
	}

	/**
	 * @param Produto Recibe un objeto de la clase producto
	 * @return 1 Si ha podido dar de alta, 0 Si no lo ha podido dar de alta
	 */
	@Override
	public int altaProducto(Producto producto) {
		
		return lista.contains(producto)?0:lista.add(producto)?1:0;
	}

	/**
	 * @param Producto Recibe el objeto producto a editar
	 * @return 1 si lo ha podido editar, 0 en caso contrario
	 */
	@Override
	public int editaProducto(Producto producto) {
		int pos= lista.indexOf(producto);
		
		if(pos == -1)
			return 0;
		else 
			return (lista.set(pos, producto)!=null)?1:0;
	}

	/**
	 * @param Producto Recibe el objeto producto a eliminar
	 * @return 1 Si lo elimina, 0 Si no ha podido eliminarlo
	 */
	@Override
	public int bajaProducto(Producto producto) {
		
		return lista.remove(producto)?1:0;
	}
	
	@Override
	public int asignaIdProducto() {
		
		return lista.size()+1;
	}
	
	//Método par carga de datos de testeo
	private void cargarDatos() {
		
		lista.add(new Producto(1, "licencia Programa Formación ", "licencia", BigDecimal.valueOf(1000), 200));
		lista.add(new Producto(2, "Impresora Laser", "laser", BigDecimal.valueOf(70), 1500));
		lista.add(new Producto(3, "Juego de rotuadores de colores", "rotuladores", BigDecimal.valueOf(150), 500));
		lista.add(new Producto(4, "Cuaderno y boligrafo", "cuaderno", BigDecimal.valueOf(0.75), 10000));
		lista.add(new Producto(5, "Flip Chart con hojas verticales", "rotafolio", BigDecimal.valueOf(500), 250));
	}

}
