package com.market.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona implements ClienteI{
    private List<Compra> compras;
    public Cliente(String nombre, String apellido,
                   String cedula, String telefono,
                   Date birth) {
        super(nombre, apellido,
                cedula, telefono,
                birth);
        this.compras = new ArrayList<>();
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }


    public void unirCliente(Compra c){
        this.getCompras().add(c);
    }
}
