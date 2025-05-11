package com.example.demo.repository;

import com.example.demo.model.DetallePedido;
import com.example.demo.model.DetallePedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoId> {

    @Query("SELECT d FROM DetallePedido d WHERE d.idPedido = :idPedido")
    List<DetallePedido> findDetallesPorIdPedido(String idPedido);
}
