package com.market.Dtos;

import com.market.Modelo.Persona;
import jakarta.persistence.Column;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class ClienteDto {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Date birth;
}