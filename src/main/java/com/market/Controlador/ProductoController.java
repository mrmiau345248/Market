package com.market.Controlador;
import com.market.Conversion.*;
import com.market.Dtos.*;
import com.market.Repos.*;
import com.market.Servicio.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;
    private final RepoProducto repoProducto ;
    private final conversionProducto conversionProducto;
    @Autowired
    public ProductoController(ProductoService productoService, RepoProducto repoProducto, conversionProducto conversionProducto) {
        this.productoService = productoService;
        this.repoProducto = repoProducto;
        this.conversionProducto = conversionProducto;
    }

    @PostMapping
    public ResponseEntity<ProductoDto> crearProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto nuevoProducto = productoService.crearProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }



}
