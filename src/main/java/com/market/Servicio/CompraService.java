package com.market.Servicio;

import com.market.Modelo.Compra;
import com.market.Modelo.Producto;
import com.market.Repos.RepoCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompraService {

    private final RepoCompra repoCompra;

    @Autowired
    public CompraService(RepoCompra repoCompra) {
        this.repoCompra = repoCompra;
    }


    // Método para buscar un producto por ID
    public boolean buscarProducto(Compra c, int productoId) {
        return c.getProductosC().stream()
                .anyMatch(p->p.getId()==productoId);

    }

    // Método para traer un producto por ID
    public Producto traerProducto(Compra compra, int id) {
        return compra.getProductosC().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para añadir un producto a la compra
    public void agregarProducto(int compraId, Producto producto) {
        Optional<Compra> compraOptional = repoCompra.findById(compraId);
        if (compraOptional.isPresent()) {
            Compra compra = compraOptional.get();
            if (!buscarProducto(compra, producto.getId())) {
                compra.getProductosC().add(producto);
                repoCompra.save(compra);
            }
        }
    }

    // Método para eliminar un producto por ID
    public void deleteProducto(int compraId, Producto producto) {
        Optional<Compra> compraOptional = repoCompra.findById(compraId);
        if (compraOptional.isPresent()) {
            Compra compra = compraOptional.get();
            Producto productoElim= traerProducto(compra,compraId);
            if (productoElim != null) {
                compra.getProductosC().remove(productoElim);
                repoCompra.save(compra);
            }
        }
    }

}
