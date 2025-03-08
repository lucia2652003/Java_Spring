package com.hackaboss.app.utilities;

import com.hackaboss.app.controllers.PedidoController;
import com.hackaboss.app.entities.Pedido;
import com.hackaboss.app.entities.Platillo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PedidoUtils {

    private List<Pedido> ordenDePedidos;

    public PedidoUtils() {
        this.ordenDePedidos = new ArrayList<>();
    }

    public ResponseEntity createPedido(Pedido pedido) {
        pedido.setId(this.ordenDePedidos.size() + 1L);
        //[{"id": 1},  {"id": 4} ]
        MenuUtils menu = new MenuUtils();
        List<Platillo> platillosDelPedido = pedido.getPedidos().stream().map(platillo -> menu.encontrarPlatillo(platillo.getId())).toList();
        pedido.setPedidos(platillosDelPedido);
        this.ordenDePedidos.add(pedido);

        return ResponseEntity.status(201).body(ordenDePedidos);
    }

    public ResponseEntity findAll() {

        return ResponseEntity.status(200).body(this.ordenDePedidos);
    }

    public ResponseEntity findByID(Long id) {
        Pedido pedido = this.ordenDePedidos.stream().filter(pedido1 -> pedido1.getId() == id).findFirst().get();
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }
}
