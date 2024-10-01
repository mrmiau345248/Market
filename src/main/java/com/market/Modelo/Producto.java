package com.market.Modelo;

import java.util.Date;

public class Producto {
    private  int id;
    private String nombre;
    private double precioC, precioV;
    private Date fechaV;

    public Producto(int id, String nombre, double precioC, double precioV, Date fechaV) {
        this.id = id;
        this.nombre = nombre;
        this.precioC = precioC;
        this.precioV = precioV;
        this.fechaV = fechaV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double precioC) {
        this.precioC = precioC;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public Date getFechaV() {
        return fechaV;
    }

    public void setFechaV(Date fechaV) {
        this.fechaV = fechaV;
    }
}

