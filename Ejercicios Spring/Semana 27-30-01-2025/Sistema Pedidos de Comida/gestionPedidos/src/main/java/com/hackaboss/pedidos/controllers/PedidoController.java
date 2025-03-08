package com.hackaboss.pedidos.controllers;

import com.hackaboss.pedidos.models.Pedido;
import com.hackaboss.pedidos.utilities.PedidoUtilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//localhost:8080/pedido                     - GET
//localhost:8080/pedido/agregar             - POST
//localhost:8080/pedido/id                  - GET

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    PedidoUtilities pedidoUtilities = new PedidoUtilities();


    //localhost:8080/pedido/agregar             - POST
    @PostMapping("/agregar")
    public ResponseEntity agregarPedido(@RequestBody Pedido pedido){
        return pedidoUtilities.createPedido(pedido);
    }


    //localhost:8080/pedido/id                  - GET
    @GetMapping("/{id}")
    public ResponseEntity mostrarPedidos(@PathVariable long id){
        return pedidoUtilities.findByOne(id);
    }
}
