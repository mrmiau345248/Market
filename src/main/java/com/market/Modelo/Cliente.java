package com.market.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cliente")
public class Cliente extends Persona {

    @OneToMany
    @Column(name="Compras")
    private List<Compra> compras;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
