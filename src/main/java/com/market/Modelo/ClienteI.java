package com.market.Modelo;

import java.util.Date;
import java.util.List;

public interface ClienteI {
    public void compraProducto(int id, Date fecha,
                              Cliente cliente, Emprendedor emprendedor,
                              String metodoPago, List<Producto> productos);

}
