package com.market.Dtos;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private  int id;
    private String nombre;
    private Double precioC;
    private Double precioV;
    private java.sql.Date fechaV;
}
