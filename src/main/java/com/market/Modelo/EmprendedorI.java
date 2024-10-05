package com.market.Modelo;

import java.util.Date;
import java.util.List;

public interface EmprendedorI {
    void ventaProducto(Compra c);
    double gastos();
    double ingresos();
    void addProducto(int id, String nombre, double precioC ,
                     double precioV, Date fechaV);
    void deleteProducto( int id);
    boolean buscarProducto(int id);
    Producto traerProducto(int id);
    void addVenta(Compra c);
}