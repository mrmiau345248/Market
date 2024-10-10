package com.market.Repos;
import com.market.Modelo.Emprendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEmprendedor extends JpaRepository<Emprendedor, Integer> {
}
