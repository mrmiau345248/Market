package com.market.Controladores;


import com.market.Modelo.Conection;
import com.market.Modelo.Emprendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@RequestMapping("/api")

public class manageDB {

    private Conection connection;

    @Autowired
    public manageDB(Conection connection) {
        this.connection = connection;
    }


    public void mostrarDB(String sql) {
        try {
           String cons= connection.ejecutarConsulta(sql);
        } catch (Exception e) {


        }

    }


    @PostMapping("/Emprendedor")
    public void crearEmprendedor(@ResponseBody Emprendedor emprendedor){
        try{

        }catch(Exception e){

        }
    }

}
