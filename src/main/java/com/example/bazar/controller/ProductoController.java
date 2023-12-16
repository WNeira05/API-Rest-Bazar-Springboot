package com.example.bazar.controller;
import com.example.bazar.service.model.Producto;
import com.example.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Long codigoProducto) {
        Producto producto = productoService.obtenerProductoPorCodigo(codigoProducto);

        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);

        return "El producto fue creado correctamente";
    }

    @PutMapping("/editar/{codigoProducto}")
    public String editarProducto(@PathVariable Long codigoProducto, @RequestBody Producto producto) {
        productoService.editarProducto(codigoProducto, producto);

        return "El producto fue editado correctamente";
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public void eliminarProducto(@PathVariable Long codigoProducto) {
        productoService.eliminarProducto(codigoProducto);

    }

    @GetMapping("/falta_stock")
    public List<Producto> obtenerProductosConFaltaStock() {
        return productoService.productosConFaltaStock();
    }
}
