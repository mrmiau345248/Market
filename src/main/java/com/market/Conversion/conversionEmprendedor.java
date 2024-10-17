package com.market.Conversion;


import com.market.Dtos.EmprendedorDto;
import com.market.Modelo.Emprendedor;
import org.springframework.stereotype.Component;

@Component
public class conversionEmprendedor {
    public EmprendedorDto volverDto(Emprendedor e){
        return new EmprendedorDto(e.getId(),e.getNombre(),e.getApellido(),e.getCedula(),e.getTelefono(),e.getBirth(),e.getIngresos(),e.getGastos());
    }
    public Emprendedor volverEmprendedor(EmprendedorDto edto){
        return new Emprendedor(edto.getId(),edto.getNombre(),edto.getApellido(),edto.getCedula(),edto.getTelefono(),edto.getBirth() );
    }

}
