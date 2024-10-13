package com.market.Servicio;

import com.market.Conversion.*;
import com.market.Dtos.ProductoDto;
import com.market.Modelo.Producto;
import com.market.Repos.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private RepoProducto repoProducto ;
    private conversionProducto conversionProducto;
    @Autowired
    public ProductoService(RepoProducto repoProducto, conversionProducto conversionProducto){
        this.repoProducto=repoProducto;
        this.conversionProducto= conversionProducto;
    }

    public ProductoDto traerProducto(int id){
        Producto p= repoProducto.findById(id).orElse(null);
        return new ProductoDto(p.getId(),p.getNombre(),p.getPrecioC(),p.getPrecioV(),p.getFechaV());
    }

    public ProductoDto crearProducto( ProductoDto pdto){
        Producto p= conversionProducto.volverEntidad(pdto);
        return conversionProducto.volverDto( repoProducto.save(p));
    }
    public void eliminarProducto(ProductoDto pdto){
        Producto p = conversionProducto.volverEntidad(pdto);
        repoProducto.delete(p);
    }
    public ProductoDto modificarProducto(int id, ProductoDto pdto){
        Producto p= conversionProducto.volverEntidad(pdto);
        return conversionProducto.volverDto( repoProducto.updat(p));
    }


}
