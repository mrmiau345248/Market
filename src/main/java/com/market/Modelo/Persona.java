package com.market.Modelo;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
abstract public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="cedula")
    private String cedula;
    @Column(name="telefono")
    private String telefono;
    @Column(name="birth")
    private Date birth;
    @Column(name="correo")
    private String correo="";
    @Column(name="contrasena")
    private String contrasena="";


}
