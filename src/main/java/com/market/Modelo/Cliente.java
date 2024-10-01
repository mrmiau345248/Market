package com.market.Modelo;

import java.util.Date;
import java.util.List;

public class Cliente extends Persona {
    private List<Compra> compras;
    public Cliente(String nombre, String apellido,
                   String cedula, String telefono,
                   Date birth, List<Compra> compras) {
        super(nombre, apellido,
                cedula, telefono,
                birth);
        this.compras = compras;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

}
