package com.example.bazar.controller;
import com.example.bazar.dto.VentaDTO;
import com.example.bazar.service.model.Producto;
import com.example.bazar.service.model.Venta;
import com.example.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{codigoVenta}")
    public Venta obtenerVenta(@PathVariable Long codigoVenta) {
        return ventaService.obtenerVentaPorCodigo(codigoVenta);
    }

    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
        return "La venta se realizó correctamente";
    }

    @PutMapping("/editar/{codigoVenta}")
    public void editarVenta(@PathVariable Long codigoVenta, @RequestBody Venta venta) {
        ventaService.editarVenta(codigoVenta, venta);
    }

    @DeleteMapping("/eliminar/{codigoVenta}")
    public void eliminarVenta(@PathVariable Long codigoVenta) {
        ventaService.eliminarVenta(codigoVenta);
    }

    @GetMapping("/productos/{codigoVenta}")
    public List<Producto> obtenerProductosDeVenta(@PathVariable Long codigoVenta) {
        return ventaService.obtenerProductosDeVenta(codigoVenta);
    }


    @GetMapping("/mayor_venta")
    public VentaDTO obtenerDatosMayorVenta() {
        return ventaService.obtenerDatosMayorVenta();
    }
}
