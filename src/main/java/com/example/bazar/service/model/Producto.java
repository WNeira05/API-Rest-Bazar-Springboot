package com.example.bazar.service.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 4, max = 50, message = " no puede estar vacio o nulo y debe contener entre 4 y 50 caracteres")
    @Column(unique = true)
    private String nombre;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 4, max = 50, message = "No puede estar vacio o nulo y debe contener entre 4 y 50 caracteres")
    private String marca;

    private Double costo;

    private int cantidadDisponible;

    @ManyToMany(mappedBy = "listaProductos")
    @JsonIgnoreProperties("listaProductos")
    private List<Venta> listaVentas;


}
