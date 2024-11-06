package com.market.Modelo;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity // Anotación para definir que es una entidad de JPA
@Table(name="emprendedor")
public class Emprendedor extends Persona {
    @OneToMany
    @Column(name = "productos")
    private List<Producto> productos ;
    @Column(name = "ingresos")
    private Double ingresos;
    @Column(name = "gastos")
    private Double gastos;
    @OneToMany
    @Column(name = "ventas")
    private List<Compra> ventas;


    public Emprendedor(int id, String nombre, String apellido, String cedula, String telefono, Date birth, String correo, String contrasena) {
        super(id, nombre, apellido, cedula, telefono, birth, correo, contrasena);
        this.productos = new ArrayList<>();
        this.ingresos = 0.0;
        this.gastos = 0.0;
        this.ventas = new ArrayList<>();
    }

    public double calcularGastos() {
      Double suma=0.0;
      for(Producto p:this.productos){
          suma+= p.getPrecioC();
      }
      return suma;
    }

    // Método para calcular los ingresos
    public double calcularIngresos() {
    Double suma=0.0;
    for (Producto p:this.productos){
        suma+=p.getPrecioV();
    }
    return suma;
    }
}
