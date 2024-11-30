package com.trabalhoArquitetura.trabalho.Repositories;
import java.util.List;

import com.trabalhoArquitetura.trabalho.Entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByIdUsuario(Integer idUsuario);
}
