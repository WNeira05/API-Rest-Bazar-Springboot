package com.example.bazar.dto;
import lombok.Data;

@Data
public class VentaDTO {

    private Long codigoVenta;
    private Double total;
    private Integer cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

}
