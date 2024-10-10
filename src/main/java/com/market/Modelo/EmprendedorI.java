package com.market.Modelo;

public interface EmprendedorI {
    void ventaProducto(Compra c);
    double gastos();
    double ingresos();
    void addProducto(int id, String nombre, double precioC ,
                     double precioV, java.sql.Date fechaV);
    void deleteProducto( int id);
    boolean buscarProducto(int id);
    Producto traerProducto(int id);
    void addVenta(Compra c);
}