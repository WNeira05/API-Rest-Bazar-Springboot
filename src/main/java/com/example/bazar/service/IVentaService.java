package com.example.bazar.service;
import com.example.bazar.dto.VentaDTO;
import com.example.bazar.service.model.Producto;
import com.example.bazar.service.model.Venta;
import java.util.List;

public interface IVentaService {

    List<Venta> listarVentas();

    Venta obtenerVentaPorCodigo(Long codigoVenta);

    void crearVenta(Venta venta);

    void editarVenta(Long codigoVenta, Venta venta);

    void eliminarVenta(Long codigoVenta);

    List<Producto> obtenerProductosDeVenta(Long codigoVenta);

    VentaDTO obtenerDatosMayorVenta();


}


