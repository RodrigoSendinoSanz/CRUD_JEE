package com.edix.proyecto.modelo.beans;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the empleados database table.
 * 
 */
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idEmpl;

	private String nombre;

	private String correo;
	
	private String password;

	private BigDecimal salario;
	
	private Date fechaIngreso;

	private Date fechaNacimiento;
	
	private Perfile perfile;
	
	private Departamento departamento;



	public Empleado() {
	}


	public Empleado(int idEmpl, String nombre, String correo, String password, BigDecimal salario, Date fechaIngreso,
			Date fechaNacimiento, Perfile perfile, Departamento departamento) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfile = perfile;
		this.departamento = departamento;
	}




	public int getIdEmpl() {
		return idEmpl;
	}



	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public BigDecimal getSalario() {
		return salario;
	}



	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public Perfile getPerfile() {
		return perfile;
	}



	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}



	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpl;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpl != other.idEmpl)
			return false;
		return true;
	}


}