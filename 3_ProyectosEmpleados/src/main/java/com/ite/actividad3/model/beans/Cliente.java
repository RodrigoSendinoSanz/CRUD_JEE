package com.ite.actividad3.model.beans;

import java.io.Serializable;
import java.math.BigDecimal;



public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String cif;
	private String domicilio;
	private BigDecimal facturacionAnual;
	private String nombre;
	private int numeroEmpleados;

	public Cliente() {
	}
	
	public Cliente(String cif, String nombre ,String domicilio, BigDecimal facturacionAnual, int numeroEmpleados) {
	
		this.cif = cif;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public BigDecimal getFacturacionAnual() {
		return this.facturacionAnual;
	}

	public void setFacturacionAnual(BigDecimal facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", domicilio=" + domicilio + ", facturacionAnual=" + facturacionAnual
				+ ", nombre=" + nombre + ", numeroEmpleados=" + numeroEmpleados + "]";
	}

}