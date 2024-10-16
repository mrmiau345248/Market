package com.market.Dtos;
import jakarta.persistence.Column;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmprendedorDto  {

    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Date birth;
    private Double ingresos;
    private Double gastos;

}