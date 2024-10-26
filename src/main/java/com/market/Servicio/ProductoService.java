package com.market.Servicio;
import com.market.Conversion.*;
import com.market.Dtos.ProductoDto;
import com.market.Modelo.Producto;
import com.market.Repos.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {
    private final RepoProducto repoProducto ;
    private final conversionProducto conversionProducto;
    @Autowired
    public ProductoService(RepoProducto repoProducto, conversionProducto conversionProducto){
        this.repoProducto=repoProducto;
        this.conversionProducto= conversionProducto;
    }

    public ProductoDto traerProducto(int id){
        Optional<Producto> optionalProducto= repoProducto.findById(id);
        Producto p= null;
        if(optionalProducto.isPresent()) {
             p = optionalProducto.get();
        }

        return new ProductoDto(p.getId(),p.getNombre(),p.getPrecioC(),p.getPrecioV(),p.getFechaV());
    }

    public ProductoDto crearProducto( ProductoDto pdto){
        Producto p= conversionProducto.volverEntidad(pdto);
        return conversionProducto.volverDto( repoProducto.save(p));
    }
    public void eliminarProducto(ProductoDto pdto){
        Optional<Producto> optionalProducto = repoProducto.findById(pdto.getId());
        Producto p= null;
        if(optionalProducto.isPresent()){
            p= conversionProducto.volverEntidad(pdto);
            repoProducto.delete(p);
        }
    }
    public ProductoDto modificarProducto( ProductoDto pdto){
        // Buscar el producto existente en la base de datos
        Optional<Producto> optionalProducto = repoProducto.findById(pdto.getId());
        Producto productoFinal;
//        Producto p = new Producto();
        if (optionalProducto.isPresent()) {
            productoFinal= optionalProducto.get();
            // Obtener el producto existente
            // Verificar y actualizar solo los campos que no sean nulos
            if (pdto.getNombre() != null) {
                productoFinal.setNombre(pdto.getNombre());
            }
            if (pdto.getPrecioC() != null) {
                productoFinal.setPrecioC(pdto.getPrecioC());
            }
            if (pdto.getPrecioV() != null) {
                productoFinal.setPrecioV(pdto.getPrecioV());
            }
            if (pdto.getFechaV() != null) {
                productoFinal.setFechaV(pdto.getFechaV());
            }
            return conversionProducto.volverDto( repoProducto.save(productoFinal));
        } else {
            // Manejar el caso donde el producto no existe
            throw new IllegalArgumentException("El producto con id " + pdto.getId() + " no existe.");
        }
    }



}
