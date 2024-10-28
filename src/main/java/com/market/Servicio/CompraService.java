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
public CompraDto traerCompra(CompraDto compraDto) {
        Optional<Compra> optionalCompra= repoCompra.findById(compraDto.getId());
        Compra c = new Compra();
        if(optionalCompra.isPresent()) {
             c= optionalCompra.get();
        }
    return conversionCompra.volverDto(c);
    }

public CompraDto modificarCompra(CompraDto compraDto) {
        Optional<Compra> optionalCompra = repoCompra.findById(compraDto.getId());
        Compra cFinal= new Compra();
        if(optionalCompra.isPresent()) {
            cFinal= optionalCompra.get();
            if(compraDto.getFecha()!=null){
                cFinal.setFecha(compraDto.getFecha());
            }
            if(compraDto.getMonto()!=null){
               cFinal.setMonto(compraDto.getMonto());
            }
            if(compraDto.getCliente()!=null){
                cFinal.setCliente(compraDto.getCliente());
            }
            if (compraDto.getEmprendedor()!=null){
                cFinal.setEmprendedor(compraDto.getEmprendedor());
            }
            if (compraDto.getMetodoPago()!=null){
                cFinal.setMetodoPago(compraDto.getMetodoPago());
            }

        }
        return conversionCompra.volverDto(repoCompra.save(cFinal));
}

public void deleteCompra(CompraDto compraDto) {
    Optional<Compra> optionalCompra = repoCompra.findById(compraDto.getId());
        if (optionalCompra.isPresent()) {
            Compra c = conversionCompra.volverCompra(compraDto);
            repoCompra.delete(c);
    }
        }
}


