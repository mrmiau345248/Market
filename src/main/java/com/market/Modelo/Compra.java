package com.market.Modelo;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Setter
@NoArgsConstructor
@Table(name="compra")
public class Compra {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name="fecha")
    private Date fecha;

    @Column(name="monto")
    private Double monto;

    @Getter
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Getter
    @ManyToOne
    @JoinColumn(name = "emprendedor")
    private Emprendedor emprendedor;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Relación con Producto
    @Column(name="productos")
    private List<Producto> productosC;

    @Getter
    @Column(name="metodoPago")
    private String metodoPago;

    public Compra(int id, Date fecha, Double monto, Cliente cliente, Emprendedor emprendedor,  String metodoPago) {
        this.id = id;
        this.fecha = fecha;
        this.monto = 0.0;
        this.cliente = cliente;
        this.emprendedor = emprendedor;
        this.productosC = new ArrayList<>();
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        double monto = 0;
        for (Producto p : this.productosC) {
            monto += p.getPrecioV();
        }
        return monto;
    }

}
