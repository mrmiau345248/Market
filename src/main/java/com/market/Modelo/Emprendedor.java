package com.market.Modelo;

import com.market.Modelo.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity // Anotación para definir que es una entidad de JPA
@Table(name="emprendedor")
public class Emprendedor extends Persona  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<Producto> productos = new ArrayList<>();
    private double ingresos;
    private double gastos;

    @OneToMany
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
    // Getters y Setters
}
