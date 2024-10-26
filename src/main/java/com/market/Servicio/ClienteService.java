package com.market.Servicio;

import com.market.Conversion.*;
import com.market.Dtos.ClienteDto;
import com.market.Modelo.Cliente;
import com.market.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.Optional;


@Service
public class ClienteService {

    private final conversionCliente conversionCliente;
    private final RepoCliente repoCliente;

    @Autowired
    public ClienteService(com.market.Conversion.conversionCliente conversionCliente, RepoCliente repoCliente) {
        this.conversionCliente = conversionCliente;
        this.repoCliente = repoCliente;
    }
    public ClienteDto crearCliente(ClienteDto cdto){
        Cliente c= conversionCliente.volverCliente(cdto);

        return conversionCliente.volverDto(repoCliente.save(c));
    }

    public ClienteDto traerCliente(ClienteDto cdto){
        Optional<Cliente> optionalCliente = repoCliente.findById(cdto.getId());
        Cliente c = null;
        if( optionalCliente.isPresent()){
             c= optionalCliente.get();
        }
        return conversionCliente.volverDto(c);
    }
    public ClienteDto modificarCliente(ClienteDto cdto) {
        Cliente c = conversionCliente.volverCliente(cdto);
        Optional<Cliente> optionalCliente = repoCliente.findById(c.getId());
        Cliente c1= new Cliente();

        if (optionalCliente.isPresent()) {
             c1 = optionalCliente.get();
            if (c.getNombre() != null) {
                c1.setNombre(c.getNombre());
            } else if (c.getApellido() != null) {
                c1.setNombre(c.getApellido());
            } else if (c.getCedula() != null) {
                c1.setCedula(c.getCedula());
            } else if (c.getTelefono() != null) {
                c1.setCedula(c.getTelefono());
            } else if (c.getBirth() != null) {
                c1.setBirth(c.getBirth());
            }
        }
    return conversionCliente.volverDto(repoCliente.save(c1));
    }

    public void eliminarCliente(ClienteDto cdto){
        Optional<Cliente> optionalCliente = repoCliente.findById(cdto.getId());
        Cliente c= new Cliente();
        if(optionalCliente.isPresent()){
            c= conversionCliente.volverCliente(cdto);
            repoCliente.delete(c);
        }
    }


}
