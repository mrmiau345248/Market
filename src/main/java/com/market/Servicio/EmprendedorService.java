package com.market.Servicio;
import com.market.Dtos.*;
import com.market.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.Modelo.*;
import com.market.Conversion.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmprendedorService {

    private final RepoProducto repoProducto;
    private RepoEmprendedor repoEmprendedor;
    private conversionEmprendedor conversionEmprendedor;
    private RepoCompra repoCompra;
    public conversionProducto conversionProducto;


    @Autowired
    public EmprendedorService(RepoEmprendedor repoEmprendedor, conversionEmprendedor conversionEmprendedor,
                              RepoCompra repoCompra, RepoProducto repoProducto,
                              conversionProducto conversionProducto) {
        this.repoEmprendedor = repoEmprendedor;
        this.conversionEmprendedor = conversionEmprendedor;
        this.repoCompra = repoCompra;
        this.repoProducto = repoProducto;
        this.conversionProducto = conversionProducto;
    }

    public EmprendedorDto crearEmprendedor(EmprendedorDto edto) {
        Emprendedor emprendedor = conversionEmprendedor.volverEmprendedor(edto) ;
        return conversionEmprendedor.volverDto(repoEmprendedor.save(emprendedor));
    }


    public EmprendedorDto traerEmprendedor(EmprendedorDto edto) {
        Optional<Emprendedor> emprendedorOptional = repoEmprendedor.findById(edto.getId());
        Emprendedor emprendedor = null;
        if(emprendedorOptional.isPresent()) {
            emprendedor=emprendedorOptional.get();
        }
        return new conversionEmprendedor().volverDto(emprendedor);
    }


    public List<ProductoDto> traerListaProductos(Emprendedor edto){
        Optional<Emprendedor> optionalEmprendedor = repoEmprendedor.findById(edto.getId());
        Emprendedor emprendedor = null;
        List<Producto> productos= new ArrayList<>();
        List<ProductoDto> productosDto= new ArrayList<>();
        if(optionalEmprendedor.isPresent()) {
            emprendedor = optionalEmprendedor.get();
            productos= emprendedor.getProductos();

            for(Producto p: productos) {
              productosDto.add(conversionProducto.volverDto(p));
            }
        }
        return productosDto;
    }


    //Completar implementacion Compra para terminar esta clase
    /*
    public List<CompraDto> traerListaVentas(Emprendedor edto){
        Optional<Emprendedor> optionalEmprendedor = repoEmprendedor.findById(edto.getId());
        Emprendedor emprendedor = null;
        List<Producto> productos= new ArrayList<>();
        List<ProductoDto> productosDto= new ArrayList<>();
        if(optionalEmprendedor.isPresent()) {
            emprendedor = optionalEmprendedor.get();
            productos= emprendedor.getProductos();

            for(Producto p: productos) {
                productosDto.add(conversionProducto.volverDto(p));
            }
        }
        return productosDto;
    }
*/

public EmprendedorDto modificarEmpleado(EmprendedorDto edto){
      Optional<Emprendedor> optionalEmprendedor = repoEmprendedor.findById(edto.getId());
      Emprendedor emprendedor = null;
      if(optionalEmprendedor.isPresent()) {
        emprendedor=optionalEmprendedor.get();

        if(edto.getNombre()!=null){
            emprendedor.setNombre(edto.getNombre());
        }
        if (edto.getApellido()!=null){
            emprendedor.setApellido(edto.getApellido());
        }
        if (edto.getCedula()!=null){
            emprendedor.setCedula(edto.getCedula());
        }
        if (edto.getTelefono()!=null){
            emprendedor.setTelefono(edto.getTelefono());
        }
        if (edto.getBirth()!=null){
            emprendedor.setBirth(edto.getBirth());
        }
        if ()


      }
return new EmprendedorDto();
}








}
//
//    public EmprendedorDto ventaProducto(EmprendedorDto edto, CompraDto crdto) {
//        Optional<Emprendedor> emprendedorOptional = repoEmprendedor.findById(edto.getId());
//        Optional<Compra> compraOptional = repoCompra.findById(crdto.getId());
//        Emprendedor emprendedor =null;
//        Compra compra = null;
//        if (emprendedorOptional.isPresent()&&compraOptional.isPresent()) {
//             emprendedor = emprendedorOptional.get();
//             compra= compraOptional.get();
//            for (Producto p : compra.getProductosC()) {
//                if (buscarProducto(emprendedor, p.getId())) {
//                    emprendedor.getProductos().remove(p);
//                }
//            }
//            emprendedor.getVentas().add(compra);
//
//        }
//        return conversionEmprendedor.volverDto(repoEmprendedor.save(emprendedor));
//    }
//}
