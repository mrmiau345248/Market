package com.market.Repos;
import com.market.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPersona  extends JpaRepository<Persona,Integer> {
}
