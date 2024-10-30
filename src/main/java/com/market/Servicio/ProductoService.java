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
        Producto p = new Producto();
        if(optionalProducto.isPresent()) {
             p = optionalProducto.get();
        }

        return conversionProducto.volverDto(p);
    }

    public ProductoDto crearProducto( ProductoDto pdto){
        Producto p= conversionProducto.volverEntidad(pdto);
        return conversionProducto.volverDto( repoProducto.save(p));
    }
    public ProductoDto eliminarProducto(int id){
        Optional<Producto> optionalProducto = repoProducto.findById(id);
        Producto p;
        if(optionalProducto.isPresent()){
           p= optionalProducto.get();
            repoProducto.delete(p);
        }
        return new ProductoDto();
    }
    public ProductoDto modificarProducto( int id, ProductoDto pdto){
        Optional<Producto> optionalProducto = repoProducto.findById(id);
        Producto productoFinal;
        if (optionalProducto.isPresent()) {
            productoFinal= optionalProducto.get();
            if (pdto.getNombre() != null) {
                productoFinal.setNombre(pdto.getNombre());
            }
            if (pdto.getCateg()!=null){
                productoFinal.setCateg(pdto.getCateg());
            }
            if (pdto.getDescrip()!=null){
                productoFinal.setDescrip(pdto.getDescrip());
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
            throw new IllegalArgumentException("El producto con id " +id + " no existe.");
        }
    }



}
