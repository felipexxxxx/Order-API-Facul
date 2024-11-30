package com.trabalhoArquitetura.trabalho.DTOs;

import com.trabalhoArquitetura.trabalho.Entities.StatusPedido;

import java.time.LocalDateTime;

public record PedidoResponseDTO(
        Integer id,
        Integer idProduto,
        Double valorTotal,
        LocalDateTime dataCompra,
        StatusPedido status
) {
    public PedidoResponseDTO(Integer id, Integer idProduto, Double valorTotal, LocalDateTime dataCompra, StatusPedido status) {
        this.id = id;
        this.idProduto = idProduto;
        this.valorTotal = valorTotal;
        this.dataCompra = dataCompra;
        this.status = status;
    }
}
