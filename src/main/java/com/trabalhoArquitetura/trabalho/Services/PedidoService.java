package com.trabalhoArquitetura.trabalho.Services;

import com.trabalhoArquitetura.trabalho.DTOs.PedidoDTO;
import com.trabalhoArquitetura.trabalho.Entities.Pedido;
import com.trabalhoArquitetura.trabalho.Entities.StatusPedido;
import com.trabalhoArquitetura.trabalho.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido createPedido(PedidoDTO data) {
        Pedido pedido = new Pedido(data);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido updateStatus(Integer id, StatusPedido newStatus) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(newStatus);
        return pedidoRepository.save(pedido);
    }
}
