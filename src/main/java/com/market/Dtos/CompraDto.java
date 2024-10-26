package com.market.Dtos;
import com.market.Modelo.*;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {
    private int id;
    private Date fecha;
    private Double monto;
    private Cliente cliente;
    private Emprendedor emprendedor;
    private String metodoPago;

}
