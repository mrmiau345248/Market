package com.market.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
abstract public class Persona {
    private String nombre;
    String apellido;
    String cedula;
    String telefono;
    private Date birth;


}
