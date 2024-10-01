package com.market.Modelo;

import java.util.Date;
import java.util.List;

public interface EmprendedorI {
    void ventaProducto(int id, Date fecha,
                       Cliente cliente, Emprendedor emprendedor,
                       String metodoPago, List<Producto> productos);
    double gastos();
    double ingresos();
    void addProducto(int id, String nombre, double precioC ,
                     double precioV, Date fechaV);
    void deleteProducto();
    boolean buscarProducto(int id);


}