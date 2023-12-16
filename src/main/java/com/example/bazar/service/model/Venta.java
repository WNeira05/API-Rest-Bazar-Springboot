package com.example.bazar.service.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;

    @NotNull(message = "No puede ser nulo")
    @FutureOrPresent(message = "Debe ser igual o mayor a la fecha de hoy")
    private LocalDate fechaVenta;
    private Double total;


    @ManyToMany
    @JoinTable(
            name = "relacion_venta_producto",
            joinColumns = @JoinColumn(name = "fk_venta", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_producto", nullable = false))
    @NotEmpty
    @NotNull(message = "Debe seleccionar al menos 1 producto")
    @JsonIgnoreProperties("listaVentas")
    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @NotNull(message = "Debe contener un Cliente")
    private Cliente cliente;
}
