package com.market.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Maretplace {
    private List<Producto> productosG;
    private List<Persona> personasG;
    private String nombre = "Marketplace";

    public Maretplace( String nombre) {
        this.productosG = new ArrayList<>();
        this.personasG = new ArrayList<>();
        this.nombre = nombre;
    }

    public List<Producto> getProductosG() {
        return productosG;
    }

    public void setProductosG(List<Producto> productosG) {
        this.productosG = productosG;
    }

    public List<Persona> getPersonasG() {
        return personasG;
    }

    public void setPersonasG(List<Persona> personasG) {
        this.personasG = personasG;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
