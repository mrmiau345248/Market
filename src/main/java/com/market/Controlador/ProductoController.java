package com.market.Controlador;
import com.market.Dtos.*;
import com.market.Servicio.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Marketplace/producto")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
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
    public ResponseEntity<ProductoDto> modificarProducto(@PathVariable int id,@RequestBody ProductoDto productoDto) {
        ProductoDto nuevoProducto =  productoService.modificarProducto(id, productoDto);
        if (nuevoProducto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(nuevoProducto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProductoDto> eliminarProducto(@PathVariable int id){
        ProductoDto nuevoProducto = productoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.OK).body(nuevoProducto);
    }
}
