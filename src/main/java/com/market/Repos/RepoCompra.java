package com.market.Repos;
import com.market.Modelo.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCompra extends JpaRepository<Compra,Integer> {
}
