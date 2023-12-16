package com.example.bazar.service.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCliente;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 4, max = 50, message = "No puede estar vacio y debe contener entre 4 y 50 caracteres")
    private String nombre;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 4, max = 50, message = "No puede estar vacio y debe contener entre 4 y 50 caracteres")
    private String apellido;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 8, max = 8, message = "No puede estar vacio y debe contener 8 caracteres")
    @Column(unique = true)
    private String dni;

}
