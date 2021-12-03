package com.eventos.beans;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private int idUsuario;
    private String username;
    private String password;
    private String email;
    private String nombre;
    private String direccion;
    private int enabled;
    private Date fecha_registro;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, String email, String nombre, String direccion, int enabled, Date fecha_registro) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.direccion = direccion;
        this.enabled = enabled;
        this.fecha_registro = fecha_registro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", enabled=" + enabled +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
