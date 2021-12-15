package com.ite.actividad3.model.beans;

import java.io.Serializable;
import java.math.BigDecimal;


public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idProducto;
	private String descripcionBreve;
	private String descripcionLarga;
	private BigDecimal precioUnitario;
	private int stock;

	public Producto() {
	}
	
	public Producto(int idProducto, String descripcionLarga, String descripcionBreve, BigDecimal precioUnitario, int stock) {
		this.idProducto = idProducto;
		this.descripcionLarga = descripcionLarga;
		this.descripcionBreve = descripcionBreve;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionBreve() {
		return this.descripcionBreve;
	}

	public void setDescripcionBreve(String descripcionBreve) {
		this.descripcionBreve = descripcionBreve;
	}

	public String getDescripcionLarga() {
		return this.descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcionBreve=" + descripcionBreve + ", descripcionLarga="
				+ descripcionLarga + ", precioUnitario=" + precioUnitario + ", stock=" + stock + "]";
	}

}