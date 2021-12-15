package com.ite.actividad3.model.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String idProyecto;
	private BigDecimal costeReal;
	private BigDecimal costesPrevisto;
	private String descripcion;
	private String estado;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private Date fechaInicio;
	private BigDecimal ventaPrevisto;
	private List<ProyectoConEmpleado> proyectoConEmpleados;
	private List<ProyectoConProducto> proyectoConProductos;
	private Cliente cliente;
	private Empleado jefeProyecto;

	
	public Proyecto() {
	}
	
	public Proyecto(String idProyecto, String descripcion, String estado, Date fechaInicio, Date fechaFinPrevisto, BigDecimal ventaPrevisto, BigDecimal costesPrevisto, Cliente cliente, Empleado jefeProyecto) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.ventaPrevisto = ventaPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.cliente = cliente;
		this.jefeProyecto = jefeProyecto;
	}

	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(BigDecimal ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public List<ProyectoConEmpleado> getProyectoConEmpleados() {
		if(this.proyectoConEmpleados == null)
			this.proyectoConEmpleados = new ArrayList<ProyectoConEmpleado>();
		
		return this.proyectoConEmpleados;
	}

	public void setProyectoConEmpleados(List<ProyectoConEmpleado> proyectoConEmpleados) {
		this.proyectoConEmpleados = proyectoConEmpleados;
	}

	public ProyectoConEmpleado addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().add(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(this);

		return proyectoConEmpleado;
	}

	public ProyectoConEmpleado removeProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().remove(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(null);

		return proyectoConEmpleado;
	}
	
	public List<ProyectoConProducto> getProyectoConProductos() {
		if(this.proyectoConProductos == null)
			this.proyectoConProductos = new ArrayList <ProyectoConProducto>();
		return this.proyectoConProductos;
	}

	public void setProyectoConProductos(List<ProyectoConProducto> proyectoConProductos) {
		this.proyectoConProductos = proyectoConProductos;
	}

	public ProyectoConProducto addProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		getProyectoConProductos().add(proyectoConProducto);
		proyectoConProducto.setProyecto(this);

		return proyectoConProducto;
	}

	public ProyectoConProducto removeProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		getProyectoConProductos().remove(proyectoConProducto);
		proyectoConProducto.setProyecto(null);

		return proyectoConProducto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getJefeProyecto() {
		return this.jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
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
		Proyecto other = (Proyecto) obj;
		if (idProyecto == null) {
			if (other.idProyecto != null)
				return false;
		} else if (!idProyecto.equals(other.idProyecto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", costeReal=" + costeReal + ", costesPrevisto=" + costesPrevisto
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", fechaFinPrevisto=" + fechaFinPrevisto
				+ ", fechaFinReal=" + fechaFinReal + ", fechaInicio=" + fechaInicio + ", ventaPrevisto=" + ventaPrevisto
				+ ", cliente=" + cliente + ", jefeProyecto=" + jefeProyecto + "]";
	}

	
	
	

}