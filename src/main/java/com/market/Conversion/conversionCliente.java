package com.market.Conversion;

import com.market.Dtos.ClienteDto;
import com.market.Modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class conversionCliente {

    public ClienteDto volverDto(Cliente c){
        return new ClienteDto(c.getId(),c.getNombre(), c.getApellido(), c.getCedula(),c.getTelefono(),c.getBirth());
    }
    public Cliente volverCliente(ClienteDto cdto){

        return new Cliente(cdto.getId(),cdto.getNombre(),cdto.getApellido(),cdto.getCedula(),cdto.getTelefono(),cdto.getBirth());

    }
}
