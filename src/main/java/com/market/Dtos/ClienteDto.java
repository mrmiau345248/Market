package com.market.Dtos;
import lombok.*;
import java.sql.Date;

@Data
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
    private String contrasena;
    private String correo;


}