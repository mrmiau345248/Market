package com.market.Modelo;

import com.market.Modelo.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Setter
@NoArgsConstructor
@Entity // Anotación para definir que es una entidad de JPA
@Table(name="emprendedor")
public class Emprendedor extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Override
    public int getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Compra> getVentas() {
        return ventas;
    }
}
