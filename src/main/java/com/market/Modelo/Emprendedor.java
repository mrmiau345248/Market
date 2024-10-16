package com.market.Modelo;

import com.market.Modelo.*;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.*;

@Setter
@NoArgsConstructor
@Entity // Anotación para definir que es una entidad de JPA
@Table(name="emprendedor")
public class Emprendedor extends Persona {
    @OneToMany
    @Column(name = "productos")
    private List<Producto> productos ;
    @Column(name = "ingresos")
    private Double ingresos;
    @Column(name = "gastos")
    private Double gastos;
    @OneToMany
    @Column(name = "ventas")
    private List<Compra> ventas;


    public Emprendedor(int id, String nombre, String apellido, String cedula, String telefono, Date birth) {
        super(id, nombre, apellido, cedula, telefono, birth);
        this.productos = new ArrayList<>();
        this.ingresos = 0.0;
        this.gastos = 0.0;
        this.ventas = new ArrayList<>();
    }

    public double getGastos() {
        return productos.stream()
                .mapToDouble(Producto::getPrecioC)
                .sum();
    }

    // Método para calcular los ingresos
    public double getIngresos() {
        return productos.stream()
                .mapToDouble(Producto::getPrecioV)
                .sum();
    }


    public List<Producto> getProductos() {
        return productos;
    }

    public List<Compra> getVentas() {
        return ventas;
    }
}
