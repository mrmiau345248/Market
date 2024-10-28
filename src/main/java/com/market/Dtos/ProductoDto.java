package com.market.Dtos;
import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private  int id;
    private String nombre;
    private String categ;
    private String descrip;
    private Double precioC;
    private Double precioV;
    private Date fechaV;
}
