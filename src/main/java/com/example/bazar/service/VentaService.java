package com.example.bazar.service;
import com.example.bazar.dto.VentaDTO;
import com.example.bazar.service.model.Producto;
import com.example.bazar.service.model.Venta;
import com.example.bazar.repository.IProductoRepository;
import com.example.bazar.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;


@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    // Mostrar todas las ventas
    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    // Mostrar ventas por código
    @Override
    public Venta obtenerVentaPorCodigo(Long codigoVenta) {
        return ventaRepository.findById(codigoVenta).orElse(null);
    }

    // Crear una venta, asigna la suma de los valores automaticamente y resta el stock del producto vendido
    @Override
    @Transactional
    public void crearVenta(Venta venta) {
        double total = 0.0;
        for (Producto producto : venta.getListaProductos()) {
            Producto productoBD = productoRepository.findById(producto.getCodigoProducto()).orElse(null);
            if (productoBD != null) {
                total += productoBD.getCosto();
                int nuevoStock = productoBD.getCantidadDisponible() - 1;
                productoBD.setCantidadDisponible(nuevoStock);
                productoRepository.save(productoBD);
            }
        }
        venta.setTotal(total);
        ventaRepository.save(venta);
    }

    // Editar una venta
    @Override
    public void editarVenta(Long codigoVenta, Venta venta) {
        ventaRepository.save(venta);

    }

    // Eliminar una venta
    @Override
    public void eliminarVenta(Long codigoVenta) {
        ventaRepository.deleteById(codigoVenta);

    }


    // Traer los productos de una venta
    @Override
    public List<Producto> obtenerProductosDeVenta(Long codigoVenta) {
        Venta venta = ventaRepository.findById(codigoVenta).orElse(null);
        if (venta != null) {
            venta.getListaProductos().size();
            return venta.getListaProductos();
        }
        return Collections.emptyList();
    }

    // Mostrar la mayor venta
    @Override
    public VentaDTO obtenerDatosMayorVenta() {

        Venta ventaMayorMonto = ventaRepository.findFirstByOrderByTotalDesc();

        if (ventaMayorMonto != null) {
            VentaDTO ventaDTO = new VentaDTO();
            ventaDTO.setCodigoVenta(ventaMayorMonto.getCodigoVenta());
            ventaDTO.setTotal(ventaMayorMonto.getTotal());
            ventaDTO.setCantidadProductos(ventaMayorMonto.getListaProductos().size());
            ventaDTO.setNombreCliente(ventaMayorMonto.getCliente().getNombre());
            ventaDTO.setApellidoCliente(ventaMayorMonto.getCliente().getApellido());
            return ventaDTO;
        } else {
            return null;
        }
    }


}
