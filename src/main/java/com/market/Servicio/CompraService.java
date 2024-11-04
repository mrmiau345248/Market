package com.market.Servicio;
import com.market.Conversion.*;
import com.market.Dtos.*;
import com.market.Modelo.*;
import com.market.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CompraService {
    private final RepoCompra repoCompra;
    private final conversionCompra conversionCompra;

    @Autowired
    public CompraService(RepoCompra repoCompra, conversionCompra conversionCompra) {
        this.repoCompra = repoCompra;
        this.conversionCompra = conversionCompra;
    }

public CompraDto crearCompra(CompraDto compraDto) {
   Compra c= conversionCompra.volverCompra(compraDto);
    return conversionCompra.volverDto(repoCompra.save(c));
}
public CompraDto traerCompra(int id) {
        Optional<Compra> optionalCompra= repoCompra.findById(id);
        Compra c = new Compra();
        if(optionalCompra.isPresent()) {
             c= optionalCompra.get();
        }
    return conversionCompra.volverDto(c);
    }

public CompraDto modificarCompra(int id, CompraDto compraDto) {
        Optional<Compra> optionalCompra = repoCompra.findById(id);
        Compra cFinal= new Compra();
        if(optionalCompra.isPresent()) {
            cFinal= optionalCompra.get();
            if(compraDto.getFecha()!=null){
                cFinal.setFecha(compraDto.getFecha());
            }
            if(compraDto.getIdCliente()!=0){
                cFinal.setIdCliente(compraDto.getIdCliente());
            }
            if (compraDto.getIdEmprendedor()!=0){
                cFinal.setIdEmprendedor(compraDto.getIdEmprendedor());
            }
            if (compraDto.getMetodoPago()!=null){
                cFinal.setMetodoPago(compraDto.getMetodoPago());
            }

        }
        return conversionCompra.volverDto(repoCompra.save(cFinal));
}

public CompraDto deleteCompra(int id) {
    Optional<Compra> optionalCompra = repoCompra.findById(id);
        Compra c;
        if (optionalCompra.isPresent()) {
            c = optionalCompra.get();
            repoCompra.delete(c);
    }
    return  new CompraDto();
        }

public List<CompraDto> listarCompra(){
    List<Compra> lista = repoCompra.findAll();
    List<CompraDto> listaDto = new ArrayList<>();
    for( Compra c : lista){
        listaDto.add(conversionCompra.volverDto(c));
    }
    return listaDto;
    }
}


