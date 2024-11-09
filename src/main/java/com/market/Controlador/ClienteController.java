package com.market.Controlador;
import com.market.Conversion.conversionCompra;
import com.market.Dtos.ClienteDto;
import com.market.Dtos.CompraDto;
import com.market.Servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/Marketplace/cliente")

public class ClienteController {
    private final conversionCompra conversionCompra;
    private final ClienteService clienteService;
    @Autowired

    public ClienteController(com.market.Conversion.conversionCompra conversionCompra, ClienteService clienteService) {
        this.conversionCompra = conversionCompra;
        this.clienteService = clienteService;
    }


    @PostMapping("/crear")
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto clienteDto) {
        ClienteDto nuevoCliente = clienteService.crearCliente(clienteDto);
        System.out.println(clienteDto.getBirth()+ "!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }
    @GetMapping("/traer/{id}")
    public ResponseEntity<ClienteDto> traerCliente(@PathVariable  int id){
        ClienteDto clienteDto = clienteService.traerCliente(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-type","application/json")
                .body(clienteDto);
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<ClienteDto> modificarCliente(@PathVariable int id,@RequestBody ClienteDto clienteDto) {
        ClienteDto nuevoCliente = clienteService.modificarCliente(id,clienteDto);
        if (nuevoCliente != null) {
            return ResponseEntity.status(HttpStatus.OK).body(nuevoCliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ClienteDto> eliminarCliente(@PathVariable int id){
        ClienteDto nuevoCliente = clienteService.eliminarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(nuevoCliente);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDto>> listarCliente(){
        List<ClienteDto> listaDto = clienteService.listarCliente();
        return ResponseEntity.status(HttpStatus.OK).body(listaDto);
    }
    @PostMapping("/comprar")
    public ResponseEntity<CompraDto> comprar(@RequestBody CompraDto compraDto){
        CompraDto compraDto1 = clienteService.comprar(compraDto);
        return  ResponseEntity.status(HttpStatus.OK).body(compraDto1);
    }

}
