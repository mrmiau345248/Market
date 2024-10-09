package com.market.Modelo;

import java.util.Date;
import java.util.List;

public class Compra implements CompraI{
    private int id;
    private Date fecha;
    private double monto;
    private Cliente cliente;
    private Emprendedor emprendedor;
    private List<Producto> productosC;

    private String metodoPago;

    public Compra(int id, Date fecha,
                   Cliente cliente,
                  Emprendedor emprendedor, String metodoPago,
                 List<Producto> productos)
    {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto();
        this.cliente = cliente;
        this.emprendedor = emprendedor;
        this.metodoPago= metodoPago;
        this.productosC = productos;
    }

    public List<Producto> getProductosC() {
        return productosC;
    }

    public void setProductosC(List<Producto> productosC) {
        this.productosC = productosC;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Emprendedor getEmprendedor() {
        return emprendedor;
    }

    public void setEmprendedor(Emprendedor emprendedor) {
        this.emprendedor = emprendedor;
    }

    @Override
    public double monto(){
        double monto=0;
        for( Producto p: this.productosC){
            monto+=p.getPrecioV();
        }


        return monto;
    }
    @Override
    public boolean buscarProducto(int id){
        boolean encontrado=false;
        for (Producto p: this.productosC ){
            if( id==p.getId()){

                encontrado=true;
                return encontrado;
            }

        }
        return encontrado;
    }

    @Override
    public Producto traerProducto(int id){
        Producto producto=null;
        for (Producto p: this.productosC ){
            if( id==p.getId()){

                producto=p;

            }

        }
        return producto;
    }




    @Override
    public void addProducto(int id, String nombre, double precioC , double precioV, java.sql.Date fechaV){

        Producto p = new Producto(id,nombre,precioC,precioV,fechaV);
        if(!buscarProducto(id)){
            this.productosC.add(p);
        }}

    @Override
    public void deleteProducto(int id){
        if(buscarProducto(id)){
            this.productosC.remove(traerProducto(id));

        }
    }


}
