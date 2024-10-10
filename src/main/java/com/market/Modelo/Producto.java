package com.market.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String nombre;
    private double precioC, precioV;
    private java.sql.Date fechaV;

}

