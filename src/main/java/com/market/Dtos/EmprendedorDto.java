package com.market.Dtos;


import com.market.Modelo.Compra;
import com.market.Modelo.Producto;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class EmprendedorDto  {

    private int id;
    private Double ingresos;
    private Double gastos;

}