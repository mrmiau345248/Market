package com.market.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private Double monto;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Emprendedor emprendedor;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Relación con Producto
    private List<Producto> productosC;

    private String metodoPago;


    public double getMonto() {
        double monto = 0;
        for (Producto p : this.productosC) {
            monto += p.getPrecioV();
        }
        return monto;
    }
}
