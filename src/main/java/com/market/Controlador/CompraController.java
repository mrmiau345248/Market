package com.market.Controlador;
import com.market.Dtos.CompraDto;
import com.market.Servicio.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/Marketplace/compra")

public class CompraController {
    private final CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/crear")
    public ResponseEntity<CompraDto> crearCompra(@RequestBody CompraDto compraDto) {
        CompraDto nuevaCompra = compraService.crearCompra(compraDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompra);
    }
    @GetMapping("/traer/{id}")
    public ResponseEntity<CompraDto> traerCompra(@PathVariable  int id){
        CompraDto compraDto = compraService.traerCompra(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-type","application/json")
                .body(compraDto);
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<CompraDto> modificarCompra(@PathVariable int id,@RequestBody CompraDto compraDto) {
        CompraDto nuevaCompra = compraService.modificarCompra(id,compraDto);
        if (nuevaCompra != null) {
            return ResponseEntity.status(HttpStatus.OK).body(nuevaCompra);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<CompraDto> eliminarCompra(@PathVariable int id){
        CompraDto nuevaCompra = compraService.deleteCompra(id);
        return ResponseEntity.status(HttpStatus.OK).body(nuevaCompra);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<CompraDto>> listarCompra(){
        List<CompraDto> listarDto= compraService.listarCompra();
        return  ResponseEntity.status(HttpStatus.OK).body(listarDto);
    }
}
