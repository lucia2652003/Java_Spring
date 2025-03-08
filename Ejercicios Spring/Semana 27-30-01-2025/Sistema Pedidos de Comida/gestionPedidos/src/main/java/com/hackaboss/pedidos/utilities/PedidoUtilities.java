package com.hackaboss.pedidos.utilities;

import com.hackaboss.pedidos.models.Pedido;
import com.hackaboss.pedidos.models.Plato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PedidoUtilities {

    private final List<Pedido> ordenPedidos;

    public PedidoUtilities() {
        this.ordenPedidos = new ArrayList<>();
    }


    public ResponseEntity findByOne(long id) {
        Pedido pedido = this.ordenPedidos.stream()
                                         .filter(pedido1 -> pedido1.getId() == id)
                                         .findFirst()
                                         .orElse(null);

        return ResponseEntity.status(200).body(pedido);
    }

    public ResponseEntity createPedido(Pedido pedido) {
        pedido.setId(this.ordenPedidos.size()+1L);

        MenuUtilities menuUtilities = new MenuUtilities();
        //[{"id":1}, {"id":4}, ...]
        List<Plato> listaPedidos = pedido.getPedidos().stream()
                                          .map(plato->menuUtilities.encontrarPlato(plato.getId()))
                                          .toList();
        pedido.setPedidos(listaPedidos);//Una vez encontrado agregarlos al pedido
        this.ordenPedidos.add(pedido);
        return ResponseEntity.status(HttpStatus.OK).body(ordenPedidos);
    }
}
