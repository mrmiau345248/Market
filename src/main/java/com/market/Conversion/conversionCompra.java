package com.market.Conversion;
import com.market.Dtos.*;
import com.market.Modelo.*;
import org.springframework.stereotype.Component;

@Component
public class conversionCompra {
public CompraDto volverDto(Compra compra){
    return new CompraDto(compra.getId(),compra.getFecha(),
            compra.getIdCliente(),compra.getIdEmprendedor(),
            compra.getProductosC(),compra.getMetodoPago());
}
public Compra volverCompra(CompraDto compraDto){
    return new Compra(compraDto.getId(),compraDto.getFecha(),
            compraDto.getIdCliente(),compraDto.getIdEmprendedor(),
            compraDto.getMetodoPago());
}

}
