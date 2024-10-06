package com.market.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprendedor extends Persona implements EmprendedorI{

    private List<Producto> productos = new ArrayList<>();
    private double ingresos, gastos;
    private List<Compra> ventas;

    public Emprendedor(String nombre, String apellido,
                       String cedula, String telefono,
                       Date birth) {
        super(nombre, apellido,
                cedula, telefono,
                birth);
        this.productos = new ArrayList<>();
        this.ingresos = ingresos();
        this.gastos = gastos();
        this.ventas = new ArrayList<>();
    }

    public List<Compra> getVentas() {
        return ventas;
    }

    public void setVentas(List<Compra> ventas) {
        this.ventas = ventas;
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
    public void ventaProducto(Compra compra
    ) {


        for( Producto p: compra.getProductosC()) {

            if(compra.buscarProducto(p.getId())){
                this.productos.remove(p);
            }

        }
        addVenta(compra);

     }
    @Override
    public boolean buscarProducto(int id){
        boolean encontrado=false;
        for (Producto p: this.productos ){
            if( id==p.getId()){

                encontrado= true;
                return encontrado;
            }

        }
        return encontrado;
    }
    @Override
    public Producto traerProducto(int id){
        Producto producto=null;
        for (Producto p: this.productos ){
            if( id==p.getId()){

                producto=p;
            }

        }
            return producto;
    }


    @Override
    public double gastos() {
        double gastos = 0;
        for (Producto p : this.productos) {
            gastos += p.getPrecioC();
        }
        return gastos;
    }

    @Override
    public double ingresos() {
        double ingresos = 0;
        for( Producto p: this.productos){
            ingresos += p.getPrecioV();
        }
        return ingresos;
    }
    @Override
    public void addProducto(int id, String nombre, double precioC , double precioV, Date fechaV){

        Producto p = new Producto(id,nombre,precioC,precioV,fechaV);
        if(!buscarProducto(id)){
           this.productos.add(p);
        }}

    @Override
    public void deleteProducto(int id){
        if(buscarProducto(id)){
           this.productos.remove(traerProducto(id));

        }
    }

    @Override
    public void addVenta(Compra c){
        this.ventas.add(c);
    }
    }


