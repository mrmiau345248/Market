package com.market.Dtos;
import com.market.Modelo.Cliente;
import com.market.Modelo.Emprendedor;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
public class CompraDto {
    private int id;
    private Date fecha;
    private Double monto;
    private Cliente cliente;
    private Emprendedor emprendedor;
    private String metodoPago;
}
