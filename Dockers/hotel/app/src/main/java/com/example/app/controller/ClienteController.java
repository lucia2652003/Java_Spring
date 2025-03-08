package com.example.app.controller;

import com.example.app.dtos.ClienteDTO;
import com.example.app.servicies.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    //Al poner esta anotación para hacer la inyección de dependencias
    @Autowired
    IClienteService service;

    //Sacamos la información y añadimos sufijos para que no se confundan
    //localhost:8080/clientes
    @GetMapping({"/", ""})
    public ResponseEntity<List<ClienteDTO>> todosClientes(){
        return ResponseEntity.status(200).body(service.mostrarClientes());
    }

    //Pasamos en el cuerpo un clienteDTO
    //localhost:8080/clientes/agregar
    @PostMapping("/agregar")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO nuevo = service.agregarCliente(clienteDTO);
        return ResponseEntity.status(201).body(nuevo);
    }

    //localhost:8080/clientes/id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> encontrarCliente(@PathVariable Long id){
        return ResponseEntity.status(200).body(service.buscarCliente(id));
    }

    //Pasamos el ID del cliente y los datos para actualizar
    //localhost:8080/clientes/id
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizarCliente(@PathVariable Long id,@RequestBody ClienteDTO clienteDTO){
        ClienteDTO modificado = service.modificarCliente(id, clienteDTO);
        return ResponseEntity.ok(modificado);
    }

    //localhost:8080/clientes/id
    @DeleteMapping("/{id}")
    public ResponseEntity<List<ClienteDTO>> bajaCliente(@PathVariable Long id){
        return ResponseEntity.ok(service.eliminarCliente(id));
    }
}
