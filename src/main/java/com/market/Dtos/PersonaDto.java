package com.market.Dtos;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract public class PersonaDto {
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Date birth;
    private String correo;
    private String contrasena;
}