package com.market.Dtos;
import com.market.Modelo.Producto;
import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {
    private int id;
    private Date fecha;
//    private Double monto;
    private int idCliente;
    private int idEmprendedor;
    private List<Producto> productos;
    private String metodoPago;
}
