package modelo.beans;

import java.io.Serializable;

public class Tipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_tipo;
	private String nombre;
	private String descripcion;

	public Tipo(int id_tipo, String nombre, String descripcion) {
		super();
		this.id_tipo = id_tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public Tipo() {
		super();
	}


	public int getId_tipo() {
		return id_tipo;
	}


	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_tipo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tipo))
			return false;
		Tipo other = (Tipo) obj;
		if (id_tipo != other.id_tipo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tipo [id_tipo=" + id_tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
