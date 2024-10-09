package com.market.Modelo;

import java.util.Date;

public interface CompraI {

    double monto();
    void addProducto(int id, String nombre, double precioC ,
                     double precioV, java.sql.Date fechaV);
    void deleteProducto( int id);
    boolean buscarProducto(int id);
    Producto traerProducto(int id);

}
