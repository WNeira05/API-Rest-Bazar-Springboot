package com.example.bazar.service;
import com.example.bazar.service.model.Cliente;
import com.example.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService implements IClienteService {


    @Autowired
    private IClienteRepository clienteRepository;

    // Crear un cliente
    @Override
    public void crearCliente(Cliente nuevoCliente) {
        clienteRepository.save(nuevoCliente);
    }

    // Mostrar lista de clientes
    @Override
    public List<Cliente> traerClientes() {
        return clienteRepository.findAll();
    }


    // Mostrar un cliente segun su ID
    @Override
    public Cliente obtenerClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }


    // Editar un cliente
    @Override
    public void editarCliente(Long idCliente, Cliente cliente) {
        clienteRepository.save(cliente);

    }
    // Eliminar un cliente segun su ID
    @Override
    public void eliminarCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
