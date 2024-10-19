package com.market.Servicio;
import com.market.Dtos.*;
import com.market.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.Modelo.*;
import com.market.Conversion.*;
import java.util.Optional;
@Service
public class EmprendedorService {

    private final RepoProducto repoProducto;
    private RepoEmprendedor repoEmprendedor;
    private conversionEmprendedor conversionEmprendedor;
    private RepoCompra repoCompra;


    @Autowired
    public EmprendedorService(RepoEmprendedor repoEmprendedor, conversionEmprendedor conversionEmprendedor, RepoCompra repoCompra, RepoProducto repoProducto) {
        this.repoEmprendedor = repoEmprendedor;
        this.conversionEmprendedor = conversionEmprendedor;
        this.repoCompra = repoCompra;
        this.repoProducto = repoProducto;
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

public modificarEmpleado(EmprendedorDto edt)








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
