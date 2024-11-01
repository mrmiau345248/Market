package com.market.Modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="cliente")
public class Cliente extends Persona {
    @OneToMany
    @Column(name="Compras")
    private List<Compra> compras;

    public Cliente(int id, String nombre,
                   String apellido, String cedula,
                   String telefono, Date birth,
                   String correo,String contrasena) {
        super(id, nombre, apellido, cedula, telefono, birth,correo,contrasena);
        this.compras = new ArrayList<>();
    }

}
