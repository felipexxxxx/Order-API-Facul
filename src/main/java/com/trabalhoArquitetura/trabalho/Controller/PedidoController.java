package com.trabalhoArquitetura.trabalho.Controller;

import com.trabalhoArquitetura.trabalho.DTOs.PedidoDTO;
import com.trabalhoArquitetura.trabalho.Entities.Pedido;
import com.trabalhoArquitetura.trabalho.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedido/usuario/{idUsuario}")
    public ResponseEntity<List<Pedido>> getPedidosByUsuario(@PathVariable Integer idUsuario) {
    List<Pedido> pedidos = pedidoService.getPedidosByUsuario(idUsuario);
    return ResponseEntity.ok(pedidos);
}

    @PostMapping()
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoDTO data) {
        Pedido pedido = pedidoService.createPedido(data);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        return ResponseEntity.ok(pedidoService.getAllPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.getPedidoById(id));
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Pedido> confirmarPedido(@PathVariable Integer id) {
        Pedido pedidoConfirmado = pedidoService.confirmarPedido(id);
        return ResponseEntity.ok(pedidoConfirmado);
    }
}
