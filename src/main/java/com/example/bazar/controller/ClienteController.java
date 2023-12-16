package com.example.bazar.controller;
import com.example.bazar.service.model.Cliente;
import com.example.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<Cliente> traerClientes() {
        return clienteService.traerClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);

        return "El cliente fue creado correctamente";
    }

    @PutMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.editarCliente(id, cliente);

        return "El cliente fue editado correctamente";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);

        return "El cliente fue eliminado correctamente";

    }
}
