package com.market.Dtos;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprendedorDto  {

    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Date birth;
    private String correo;
    private String contrasena;
    private Double ingresos;
    private Double gastos;

}