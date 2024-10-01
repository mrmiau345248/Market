package com.market.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprendedor extends Persona implements EmprendedorI{

    private List<Producto> productos = new ArrayList<>();
    private double ingresos, gastos;

    public Emprendedor(String nombre, String apellido,
                       String cedula, String telefono,
                       Date birth) {
        super(nombre, apellido,
                cedula, telefono,
                birth);
        this.productos = new ArrayList<>();
        this.ingresos = ingresos();
        this.gastos = gastos();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    @Override
    public void ventaProducto(int id, Date fecha,
                              Cliente cliente, Emprendedor emprendedor,
                              String metodoPago,List<Producto> productos
    ) {
        Compra compra = new Compra(id, fecha, cliente, emprendedor, metodoPago, productos);


        for( Producto p: compra.getProductosC()) {

            if(compra.buscarProducto(p.getId())){
                this.productos.remove(p);
            }

        }

     }
    @Override
    public boolean buscarProducto(int id){
        for (Producto p: this.productos ){
            if( id==p.getId()){

                return true;
            }

        }
        return false;
    }


    @Override
    public double gastos() {
        return 0;
    }

    @Override
    public double ingresos() {
        return 0;
    }
    @Override
    public void addProducto(int id, String nombre, double precioC , double precioV, Date fechaV){

        Producto p = new Producto(id,nombre,precioC,precioV,fechaV);
        if(!buscarProducto(id)){
           this.productos.add(p);
        }}

    @Override
    public void deleteProducto(){

    }
    }


