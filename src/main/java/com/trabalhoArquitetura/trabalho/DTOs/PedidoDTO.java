package com.trabalhoArquitetura.trabalho.DTOs;

import com.trabalhoArquitetura.trabalho.Entities.StatusPedido;

public record PedidoDTO(
    Integer idUsuario,
    Integer idProduto,
    Double valorTotal,
    StatusPedido status // Permite que o cliente forneça um status opcional
) {}
