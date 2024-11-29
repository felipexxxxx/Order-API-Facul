package com.trabalhoArquitetura.trabalho.Entities;

import com.trabalhoArquitetura.trabalho.DTOs.PedidoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Pedido")
public class Pedido {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer idUsuario;

    private Integer idProduto;

    private Double valorTotal;

    private LocalDateTime dataCompra;

    @Enumerated(EnumType.STRING) // Armazena o ENUM como string no banco de dados
    private StatusPedido status;

    public Pedido(PedidoDTO data) {
        this.idUsuario = data.idUsuario();
        this.idProduto = data.idProduto();
        this.valorTotal = data.valorTotal();
        this.dataCompra = LocalDateTime.now(); // Define a data de criação
        this.status = StatusPedido.PENDENTE; // Define o status inicial como PENDENTE
    }
}
