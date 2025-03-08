package com.hackaboss.app.controllers;

import com.hackaboss.app.entities.Pedido;
import com.hackaboss.app.utilities.PedidoUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    PedidoUtils pedidoUtils = new PedidoUtils();

    @GetMapping({"/",""})
    public ResponseEntity obtenerRecurso(){
        return pedidoUtils.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerRecursoPorID(@PathVariable Long id){
        return pedidoUtils.findByID(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarRecurso(@RequestBody Pedido pedido){
        return pedidoUtils.createPedido(pedido);
    }
}
