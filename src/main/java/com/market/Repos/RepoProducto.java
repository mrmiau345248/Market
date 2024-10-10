package com.market.Repos;

import com.market.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProducto extends JpaRepository<Producto,Integer> {


}
