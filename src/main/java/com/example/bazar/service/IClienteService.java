package com.example.bazar.service;
import com.example.bazar.service.model.Cliente;
import java.util.List;

public interface IClienteService {

    void crearCliente(Cliente nuevoCliente);
    List<Cliente> traerClientes();
    Cliente obtenerClientePorId(Long idCliente);
    void editarCliente(Long idCliente, Cliente cliente);
    void eliminarCliente(Long idCliente);
}
