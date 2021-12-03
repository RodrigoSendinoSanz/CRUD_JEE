package com.eventos.beans;

import java.io.Serializable;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idReserva;
    private int idEvento;
    private int idUsuario;
    private float precioVenta;
    private String observaciones;
    private int cantidad;

    public Reserva() {
    }

    public Reserva(int idEvento, int idUsuario, float precioVenta, String observaciones, int cantidad) {
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
        this.precioVenta = precioVenta;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", idEvento=" + idEvento +
                ", idUsuario=" + idUsuario +
                ", precioVenta=" + precioVenta +
                ", observaciones='" + observaciones + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
