package com.market.Servicio;

import com.market.Repos.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private RepoProducto repoProducto ;
    @Autowired
    public ProductoService(RepoProducto repoProducto){
        this.repoProducto=repoProducto;
    }

}
