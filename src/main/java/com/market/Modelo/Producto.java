package com.market.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="precioC")
    private Double precioC;
    @Column(name="precioV")
    private Double precioV;
    @Column(name="fechaV")
    private java.sql.Date fechaV;

}

