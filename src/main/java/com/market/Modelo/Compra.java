package com.market.Modelo;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="monto")
    private Double monto;

    @Column(name = "cliente")
    private int idCliente;

   @Column(name = "emprendedor")
    private int idEmprendedor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Relación con Producto
    @Column(name="productos")
    private List<Producto> productosC;

    @Column(name="metodoPago")
    private String metodoPago;

    public Compra(int id, Date fecha,  int idCliente, int idEmprendedor,  String metodoPago) {
        this.id = id;
        this.fecha = fecha;
        this.monto = 0.0;
        this.idCliente = idCliente;
        this.idEmprendedor = idEmprendedor;
        this.productosC = new ArrayList<>();
        this.metodoPago = metodoPago;
    }

    public double calcularMonto() {
        double monto = 0.0;
        for (Producto p : this.productosC) {
            monto += p.getPrecioV();
        }
        return monto;
    }

}
