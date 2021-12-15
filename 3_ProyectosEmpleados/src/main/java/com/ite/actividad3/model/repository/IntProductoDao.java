package com.ite.actividad3.model.repository;

import java.util.List;


import com.ite.actividad3.model.beans.Producto;

public interface IntProductoDao {
	List<Producto> findAll(); //Devuelve una lista con todos los productos
	Producto findById(int idproducto); //Devuelve el producto
	int altaProducto(Producto producto); //Da de alta un producto
	int editaProducto(Producto producto); //Edita un producto
	int bajaProducto (Producto producto); //Da de baja un producto
	int asignaIdProducto(); //Asigna de forma automática la id
}
