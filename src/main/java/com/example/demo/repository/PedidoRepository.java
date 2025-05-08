package com.example.demo.repository;

import com.example.demo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, String> {

    @Query("SELECT p.idPedido FROM Pedido p ORDER BY p.idPedido DESC")
    List<String> obtenerUltimoIdPedido();
}
