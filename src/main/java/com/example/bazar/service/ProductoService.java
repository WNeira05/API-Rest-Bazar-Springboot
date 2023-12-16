package com.example.bazar.service;
import com.example.bazar.service.model.Producto;
import com.example.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;


    // Mostrar los productos
    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Mostrar producto por código
    @Override
    public Producto obtenerProductoPorCodigo(Long codigoProducto) {
        return productoRepository.findById(codigoProducto).orElse(null);
    }

    // Crear un producto
    @Override
    public void crearProducto(Producto producto) {
        productoRepository.save(producto);

    }

    // Editar un producto
    @Override
    public void editarProducto(Long codigoProducto, Producto producto) {
        producto.setCodigoProducto(codigoProducto);
        productoRepository.save(producto);

    }

    // Eliminar un producto
    @Override
    public String eliminarProducto(Long codigoProducto) {
        if (productoRepository.existsById(codigoProducto)) {
            productoRepository.deleteById(codigoProducto);
            return "El producto fue eliminado correctamente";
        }
        return "El producto con ese ID no existe";
    }


    @Override
    public List<Producto> productosConFaltaStock() {
        return productoRepository.findByCantidadDisponibleLessThan(5.0);
    }
}
