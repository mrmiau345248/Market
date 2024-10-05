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
    @Override
    public void compraProducto(int id, Date fecha,
                              Cliente cliente, Emprendedor emprendedor,
                              String metodoPago,List<Producto> productos
    ) {
        Compra compra = new Compra(id, fecha, cliente, emprendedor, metodoPago, productos);

        this.compras.add(compra);

    }


}
