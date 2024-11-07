package com.market.Servicio;
import com.market.Dtos.LoginDto;
import com.market.Modelo.*;
import com.market.Repos.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class AutenticacionService {

    private final RepoCliente repoCliente;
    private final RepoEmprendedor repoEmprendedor;

    @Autowired
    public AutenticacionService(RepoCliente repoCliente, RepoEmprendedor repoEmprendedor) {
        this.repoCliente = repoCliente;
        this.repoEmprendedor = repoEmprendedor;
    }

    public boolean loginCliente(LoginDto loginDto) {
        List<Cliente> clientes = repoCliente.findAll();
        boolean login = false;
        for (Cliente c : clientes) {
            if (c.getCorreo().equals(loginDto.getCorreo()) && c.getContrasena().equals(loginDto.getContrasena())) {
                login = true;
            }
        }

        return login;

    }

    public boolean loginEmprendedor(LoginDto loginDto) {
        List<Emprendedor> emprendedores = repoEmprendedor.findAll();
        boolean login = false;
        for (Emprendedor e : emprendedores) {
            if (e.getCorreo().equals(loginDto.getCorreo()) && e.getContrasena().equals(loginDto.getContrasena())) {
                    login = true;
                }
            }

            return login;


    }
}