package com.market.Controlador;

import com.market.Conversion.conversionProducto;
import com.market.Repos.RepoProducto;
import com.market.Servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;
    private final RepoProducto repoProducto ;
    private final com.market.Conversion.conversionProducto conversionProducto;
    @Autowired
    public ProductoController(ProductoService productoService, RepoProducto repoProducto, com.market.Conversion.conversionProducto conversionProducto) {
        this.productoService = productoService;
        this.repoProducto = repoProducto;
        this.conversionProducto = conversionProducto;
    }

    



}
