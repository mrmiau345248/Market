package com.market.Dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
abstract public class PersonaDto {
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private java.sql.Date birth;


}