package com.market.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name="Marketplace")
public class Marketplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="productosG")
    @OneToMany
    private List<Producto> productosG;
    @OneToMany
    @Column(name="personasG")
    private List<Persona> personasG;
    @Column(name="nombre")
    private String nombre = "Marketplace";

    public Marketplace(String nombre) {
        this.productosG = new ArrayList<>();
        this.personasG = new ArrayList<>();
        this.nombre = nombre;
    }
}