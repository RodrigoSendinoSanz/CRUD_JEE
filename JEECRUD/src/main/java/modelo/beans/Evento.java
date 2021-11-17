package modelo.beans;

import java.io.Serializable;


public class Evento implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int id_evento;
	private String nombre;
	private String descripcion;
	private String fecha_inicio;
	private int duracion;
	private String direccion;
	private String estado;
	private String destacado;
	private int aforo_maximo;
	private int minimo_asistencia;
	private double precio;
	private Tipo id_tipo;

	public Evento(int id_evento, String nombre, String descripcion, String fecha_inicio, int duracion, String direccion,
			String estado, String destacado, int aforo_maximo, int minimo_asistencia, double precio, Tipo id_tipo) {
		super();
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforo_maximo = aforo_maximo;
		this.minimo_asistencia = minimo_asistencia;
		this.precio = precio;
		this.id_tipo = id_tipo;
	}


	public Evento() {
		super();
	}


	public int getId_evento() {
		return id_evento;
	}


	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
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


	public String getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDestacado() {
		return destacado;
	}


	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}


	public int getAforo_maximo() {
		return aforo_maximo;
	}


	public void setAforo_maximo(int aforo_maximo) {
		this.aforo_maximo = aforo_maximo;
	}


	public int getMinimo_asistencia() {
		return minimo_asistencia;
	}


	public void setMinimo_asistencia(int minimo_asistencia) {
		this.minimo_asistencia = minimo_asistencia;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Tipo getId_tipo() {
		return id_tipo;
	}


	public void setId_tipo(Tipo id_tipo) {
		this.id_tipo = id_tipo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_evento;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (id_evento != other.id_evento)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Evento [id_evento=" + id_evento + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fecha_inicio=" + fecha_inicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado="
				+ estado + ", destacado=" + destacado + ", aforo_maximo=" + aforo_maximo + ", minimo_asistencia="
				+ minimo_asistencia + ", precio=" + precio + ", id_tipo=" + id_tipo + "]";
	}
	
	

	
	
}
