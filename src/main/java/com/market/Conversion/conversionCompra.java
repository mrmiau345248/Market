package com.market.Conversion;
import com.market.Dtos.*;
import com.market.Modelo.*;
import org.springframework.stereotype.Component;

@Component
public class conversionCompra {
    //COMO HACER QUE EL MONTO SIENDO UN ATRIBUTO DE LA COMPRA SE TRANSFIERA EN EL DTO PERO SIN LLEGAR POR PARAMETRO PORQUE
//    // SE DEBERIA PODER TRANSFERIR POR DTO
//public CompraDto volverDto(Compra compra){
//    return new CompraDto(compra.getId(),compra.getFecha(),
//            compra.getIdCliente(),compra.getIdEmprendedor(),
//            compra.getMetodoPago());
//}
//public Compra volverCompra(CompraDto compraDto){
//    return new Compra(compraDto.getId(),compraDto.getFecha(),
//            compraDto.getMonto(),compraDto.getCliente(),
//            compraDto.getEmprendedor(),compraDto.getMetodoPago());
//}

}
