package com.market.Dtos;


import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private  int id;
    private String nombre;
    private double precioC;
    private double precioV;
    private java.sql.Date fechaV;


}
