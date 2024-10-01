package com.market.Modelo;

import java.util.Date;

public interface EmprendedorI {
    void VentaProducto(int id, Date fecha,
                       Cliente cliente, Emprendedor emprendedor,
                       String metodoPago
                       );
    double gastos();
    double ingresos();
    void addProducto(int id, String nombre, double precioC , double precioV, Date fechaV);
    void deleteProducto();
    boolean buscarProducto(int id,);


}