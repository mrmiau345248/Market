package com.market.Modelo;

import com.market.MarketApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
@Service
public class Conection {

    private final JdbcTemplate jdbcTemplate;
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String username = "system";
    private String password = "240711";
    private Connection connection;

    // Constructor para establecer la conexión
    public Conection(JdbcTemplate jdbcTemplate) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
        this.jdbcTemplate = jdbcTemplate;
    }

    // Método para ejecutar una consulta y obtener resultados
    public String ejecutarConsulta(String sql) {
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getString(2);  // Devuelve el valor de la segunda columna
            } else {
                return "No se encontraron resultados.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar la consulta", e);
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexión", e);
        }
    }

    /*
    public void crearEmprendedor(String nombre, String apellido,
                                 String cedula, String telefono,
                                 Date birth){

    String sql= "INSERT INTO Emprendedor(nombre, "

    }*/

    public void crearProducto(int id, String nombre, double precioC, double precioV, Date fechaV){
        String sql= "INSERT INTO Producto(id,nombre, precioC, precioV, fechaV) VALUES(?,?,?,?,?)";

        try{
            jdbcTemplate.update(sql,id,nombre,precioC,precioV,fechaV);
        }catch (Exception e){
            throw new RuntimeException("Error al agregar el emprendedor", e);
        }

    }
}