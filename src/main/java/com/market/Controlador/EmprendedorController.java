package com.market.Controlador;
import com.market.Dtos.EmprendedorDto;
import com.market.Servicio.EmprendedorService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/Marketplace/emprendedor")

public class EmprendedorController {
    private final EmprendedorService emprendedorService;

    public EmprendedorController(EmprendedorService emprendedorService) {
        this.emprendedorService = emprendedorService;
    }

    @PostMapping("/crear")
    public ResponseEntity<EmprendedorDto> crearEmprendedor(@RequestBody EmprendedorDto emprendedorDto) {
        EmprendedorDto nuevoEmprendedor = emprendedorService.crearEmprendedor(emprendedorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmprendedor);
    }
    @GetMapping("/traer/{id}")
    public ResponseEntity<EmprendedorDto> traerEmprendedor(@PathVariable  int id){
        EmprendedorDto emprendedorDto = emprendedorService.traerEmprendedor(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-type","application/json")
                .body(emprendedorDto);
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<EmprendedorDto> modificarEmprendedor(@PathVariable int id,@RequestBody EmprendedorDto emprendedorDto) {
        EmprendedorDto nuevoEmprendedor = emprendedorService.modificarEmpleado(id,emprendedorDto);
        if (nuevoEmprendedor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(nuevoEmprendedor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmprendedorDto> eliminarEmprendedor(@PathVariable int id){
        EmprendedorDto nuevoEmprendedor = emprendedorService.eliminarEmprendedor(id);
        return ResponseEntity.status(HttpStatus.OK).body(nuevoEmprendedor);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<EmprendedorDto>> listarEmprendedor(){
        List<EmprendedorDto> listaDto = emprendedorService.listarEmprendedor();
        return ResponseEntity.status(HttpStatus.OK).body(listaDto);
    }

}
