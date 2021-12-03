package com.eventos.beans;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idEvento;
    private String nombreEvento;
    private Date fecha_inicio;
    private int duracion;
    private String direccion;
    private String estado;
    private String destacado;
    private int aforo_maximo;
    private int asistencia_minima;
    private float precio;

    public Evento() {
    }

    public Evento(int idEvento, String nombreEvento, Date fecha_inicio, int duracion, String direccion,
                  String estado, String destacado, int aforo_maximo, int asistencia_minima, float precio) {
        super();
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fecha_inicio = fecha_inicio;
        this.duracion = duracion;
        this.direccion = direccion;
        this.estado = estado;
        this.destacado = destacado;
        this.aforo_maximo = aforo_maximo;
        this.asistencia_minima = asistencia_minima;
        this.precio = precio;
    }

    public int getIdEvento() {return idEvento;}

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombre) {
        this.nombreEvento = nombre;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
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

    public int getAsistencia_minima() {
        return asistencia_minima;
    }

    public void setAsistencia_minima(int asistencia_minima) {
        this.asistencia_minima = asistencia_minima;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Evento [idEvento=" + idEvento + ", nombre=" + nombreEvento + ", fecha_inicio=" + fecha_inicio + ", duracion="
                + duracion + ", direccion=" + direccion + ", estado=" + estado + ", destacado=" + destacado
                + ", aforo_maximo=" + aforo_maximo + ", asistencia_minima=" + asistencia_minima + ", precio=" + precio
                + "]";
    }


}
