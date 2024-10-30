package com.market.Controlador;
import com.market.Conversion.*;
import com.market.Dtos.*;
import com.market.Repos.*;
import com.market.Servicio.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Marketplace/producto")
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

    @PostMapping("/crear")
    public ResponseEntity<ProductoDto> crearProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto nuevoProducto = productoService.crearProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
    @GetMapping("/traer/{id}")
    public ResponseEntity<ProductoDto> traerProducto(@PathVariable  int id){
        ProductoDto producto = productoService.traerProducto(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-type","application/json")
                .body(producto);
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<ProductoDto> modificarProducto(@PathVariable int id) {
        System.out.println("Holaaaaaaaaa" );
        ProductoDto nuevoProducto = productoService.traerProducto(id);
        if (nuevoProducto != null) {
            return ResponseEntity.ok(nuevoProducto); // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
}
