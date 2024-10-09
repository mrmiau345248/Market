package com.market.Controladores;


import com.market.Modelo.Conection;
import com.market.Modelo.Emprendedor;
import com.market.Modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;

@RestController
@RequestMapping("/api")

public class manageDB {

    private final Conection conection;

    @Autowired
    public manageDB(Conection conection) {
        this.conection = conection;
    }


    public void mostrarDB(String sql) {
        try {
           String cons= conection.ejecutarConsulta(sql);
        } catch (Exception e) {


        }

    }


    @PostMapping("/Producto")
    public void crearProducto(@RequestBody Producto producto){
        try{
            conection.crearProducto(producto.getId(),producto.getNombre(),producto.getPrecioC(),producto.getPrecioV(), producto.getFechaV());
        }catch(Exception e){
            throw new RuntimeException("Error al agregar el emprendedor", e);

        }
    }

}
