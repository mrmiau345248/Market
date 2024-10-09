package com.market.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprendedor extends Persona implements EmprendedorI{

    private List<Producto> productos = new ArrayList<>();
    private double ingresos;
    private double gastos;
    private List<Compra> ventas;


    @Autowired
    public Emprendedor(String nombre, String apellido,
                       String cedula, String telefono,
                       Date birth, Conection conection) {
        super(nombre, apellido,
                cedula, telefono,
                birth);
        this.productos = new ArrayList<>();
        this.ingresos = ingresos();
        this.gastos = gastos();
        this.ventas = new ArrayList<>();
        this.conection;

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
    public void addProducto(int id, String nombre, double precioC , double precioV, java.sql.Date fechaV){

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


