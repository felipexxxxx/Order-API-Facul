package com.trabalhoArquitetura.trabalho.Services;

import com.trabalhoArquitetura.trabalho.DTOs.PedidoDTO;
import com.trabalhoArquitetura.trabalho.DTOs.PedidoResponseDTO;
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
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido confirmarPedido(Integer id) {
        Pedido pedido = getPedidoById(id);

        if (!pedido.getStatus().equals(StatusPedido.PENDENTE)) {
            throw new IllegalStateException("O pedido já foi confirmado!");
        }

        pedido.setStatus(StatusPedido.PAGO);
        return pedidoRepository.save(pedido);
    }
    
    public List<PedidoResponseDTO> getPedidosByUsuario(Integer idUsuario) {
        List<Pedido> pedidos = pedidoRepository.findByIdUsuario(idUsuario);

        // Mapeando os pedidos para o DTO
        return pedidos.stream()
                .map(pedido -> new PedidoResponseDTO(
                        pedido.getId(),
                        pedido.getIdProduto(),
                        pedido.getValorTotal(),
                        pedido.getDataCompra(),
                        pedido.getStatus()
                ))
                .toList();
    }
}
