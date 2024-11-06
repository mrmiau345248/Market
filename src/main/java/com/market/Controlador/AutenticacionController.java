package com.market.Controlador;
import com.market.Dtos.*;
import com.market.Servicio.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/Marketplace/auth")
public class AutenticacionController {
    private final AutenticacionService autenticacionService;
    @Autowired
    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    @PostMapping("/loginCliente")
    public ResponseEntity<Boolean> loginCliente(@RequestBody LoginDto loginDto){
            return ResponseEntity.status(HttpStatus.OK).body( autenticacionService.loginCliente(loginDto));
    }
    @PostMapping("/loginEmprendedor")
    public ResponseEntity<Boolean> loginEmprendedor(@RequestBody LoginDto loginDto){
        return ResponseEntity.status(HttpStatus.OK).body( autenticacionService.loginEmprendedor(loginDto));
    }

}
