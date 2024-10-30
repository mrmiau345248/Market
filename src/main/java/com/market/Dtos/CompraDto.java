package com.market.Dtos;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {
    private int id;
    private Date fecha;
    private Double monto;
    private int idCliente;
    private int idEmprendedor;
    private String metodoPago;

}
