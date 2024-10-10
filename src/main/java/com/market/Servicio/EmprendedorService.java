package com.market.Servicio;

import com.market.Repos.RepoEmprendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.market.Modelo.*;

import java.util.Optional;

@Service
public class EmprendedorService {

    private RepoEmprendedor repoEmprendedor;

    @Autowired
    public EmprendedorService(RepoEmprendedor repoEmprendedor){
        this.repoEmprendedor=repoEmprendedor;
    }

    // Lógica de negocio para la venta de un producto
    public void ventaProducto(int emprendedorId, Compra compra) {
        Optional<Emprendedor> emprendedorOptional = repoEmprendedor.findById(emprendedorId);
        if (emprendedorOptional.isPresent()) {
            Emprendedor emprendedor = emprendedorOptional.get();

            // Remover los productos de la lista de productos del emprendedor
            for (Producto p : compra.getProductosC()) {
                if (buscarProducto(emprendedor, p.getId())) {
                    emprendedor.getProductos().remove(p);
                }
            }

            // Añadir la venta a la lista de ventas
            emprendedor.getVentas().add(compra);

            // Guardar cambios en la base de datos
            repoEmprendedor.save(emprendedor);
        }
    }

    // Lógica para buscar un producto en la lista de productos del emprendedor
    public boolean buscarProducto(Emprendedor emprendedor, int producotId) {
        return emprendedor.getProductos().stream()
                .anyMatch(p -> p.getId() == producotId);
    }

    // Lógica para traer un producto de la lista del emprendedor
    public Producto traerProducto(Emprendedor emprendedor, int id) {
        return emprendedor.getProductos().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Lógica para agregar un producto
    public void agregarProducto(int emprendedorId, Producto producto) {
        Optional<Emprendedor> emprendedorOptional = repoEmprendedor.findById(emprendedorId);
        if (emprendedorOptional.isPresent()) {
            Emprendedor emprendedor = emprendedorOptional.get();
            if (!buscarProducto(emprendedor, producto.getId())) {
                emprendedor.getProductos().add(producto);
                repoEmprendedor.save(emprendedor);
            }
        }
    }

    // Lógica para eliminar un producto
    public void eliminarProducto(int emprendedorId, int productoId) {
        Optional<Emprendedor> emprendedorOptional = repoEmprendedor.findById(emprendedorId);
        if (emprendedorOptional.isPresent()) {
            Emprendedor emprendedor = emprendedorOptional.get();
            Producto productoAEliminar = traerProducto(emprendedor, productoId);
            if (productoAEliminar != null) {
                emprendedor.getProductos().remove(productoAEliminar);
                repoEmprendedor.save(emprendedor);
            }
        }
    }

    // Lógica para calcular ingresos
    public double calcularIngresos(Emprendedor emprendedor) {
        return emprendedor.getProductos().stream()
                .mapToDouble(Producto::getPrecioV)
                .sum();
    }

    // Lógica para calcular gastos
    public double calcularGastos(Emprendedor emprendedor) {
        return emprendedor.getProductos().stream()
                .mapToDouble(Producto::getPrecioC)
                .sum();
    }
}
