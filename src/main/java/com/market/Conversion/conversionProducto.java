package com.market.Conversion;
import com.market.Dtos.ProductoDto;
import com.market.Modelo.*;
import org.springframework.stereotype.*;

@Component
public class conversionProducto {
public ProductoDto volverDto(Producto p){
    return new ProductoDto(p.getId(),p.getNombre(),
            p.getCateg(),p.getDescrip(),
            p.getPrecioC(),p.getPrecioV(),
            p.getFechaV());
}
public Producto volverEntidad(ProductoDto pdto){
    return new Producto(pdto.getId(),pdto.getNombre(),
            pdto.getCateg(),pdto.getDescrip(),
            pdto.getPrecioC(),pdto.getPrecioV(),
            pdto.getFechaV());
}

}
