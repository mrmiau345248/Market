package com.market.Repos;

import com.market.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCliente extends JpaRepository<Cliente,Integer> {
}
