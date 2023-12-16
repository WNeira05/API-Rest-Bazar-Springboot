package com.example.bazar.service;
import com.example.bazar.service.model.Producto;
import java.util.List;

public interface IProductoService {

    List<Producto> listarProductos();
    Producto obtenerProductoPorCodigo(Long codigoProducto);
    void crearProducto(Producto producto);
    void editarProducto(Long codigoProducto, Producto producto);
    String eliminarProducto(Long codigoProducto);
    List<Producto> productosConFaltaStock();
}
