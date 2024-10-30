package com.market.Controlador;
import com.market.Dtos.ClienteDto;
import com.market.Servicio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Marketplace/cliente")

public class ClienteController {
    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto clienteDto) {
        ClienteDto nuevoCliente = clienteService.crearCliente(clienteDto);
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
}
