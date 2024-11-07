package com.market.Servicio;
import com.market.Conversion.*;
import com.market.Dtos.ClienteDto;
import com.market.Dtos.CompraDto;
import com.market.Dtos.ProductoDto;
import com.market.Modelo.*;
import com.market.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;


@Service
public class ClienteService {

    private final conversionCliente conversionCliente;
    private final RepoCliente repoCliente;
    private final conversionCompra conversionCompra;
    private  final RepoEmprendedor repoEmprendedor;
    @Autowired
    public ClienteService(conversionCliente conversionCliente, RepoCliente repoCliente,
                          conversionCompra conversionCompra, RepoEmprendedor repoEmprendedor) {
        this.conversionCliente = conversionCliente;
        this.repoCliente = repoCliente;
        this.conversionCompra = conversionCompra;
        this.repoEmprendedor = repoEmprendedor;
    }


    public ClienteDto crearCliente(ClienteDto cdto){
        Cliente c= conversionCliente.volverCliente(cdto);

        return conversionCliente.volverDto(repoCliente.save(c));
    }

    public ClienteDto traerCliente(int id){
        Optional<Cliente> optionalCliente = repoCliente.findById(id);
        Cliente c = new Cliente();
        if( optionalCliente.isPresent()){
             c= optionalCliente.get();
        }
        return conversionCliente.volverDto(c);
    }
    public ClienteDto modificarCliente(int id, ClienteDto cdto) {
        Cliente c = conversionCliente.volverCliente(cdto);
        Optional<Cliente> optionalCliente = repoCliente.findById(id);
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

    public ClienteDto eliminarCliente(int id){
        Optional<Cliente> optionalCliente = repoCliente.findById(id);
        Cliente c;
        if(optionalCliente.isPresent()){
            c= optionalCliente.get();
            repoCliente.delete(c);
        }
        return new ClienteDto();
    }
    public List<CompraDto> traerCompras(int id){
        Optional<Cliente> optionalCliente = repoCliente.findById(id);
        Cliente c;
        List<Compra> compras ;
        List<CompraDto> comprasDto = new ArrayList<>();
        if( optionalCliente.isPresent()){
            c= optionalCliente.get();
            compras= c.getCompras();

            for(Compra compra: compras){
                comprasDto.add(conversionCompra.volverDto(compra));
            }

        }
        return comprasDto;
    }
    public List<ClienteDto> listarCliente(){
        List<Cliente> lista = repoCliente.findAll();
        List<ClienteDto> listaDto = new ArrayList<>();
        for (Cliente c: lista){
            listaDto.add(conversionCliente.volverDto(c));
        }
        return listaDto;
    }
    public CompraDto comprar(CompraDto compraDto) {
        Optional<Emprendedor> emprendedorOptional = repoEmprendedor.findById(compraDto.getIdEmprendedor());
        Optional<Cliente> clienteOptional = repoCliente.findById(compraDto.getIdCliente());
        Emprendedor e;
        Cliente c;
        Compra compra = conversionCompra.volverCompra(compraDto);
        if(emprendedorOptional.isPresent() && clienteOptional.isPresent()){
            c = clienteOptional.get();
            e=emprendedorOptional.get();
            c.getCompras().add(compra);
            e.getVentas().add(compra);
            compra.calcularMonto();
        }
        return conversionCompra.volverDto(compra);
    }


}
