package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_detalle_pedido")
@IdClass(DetallePedidoId.class)
@Data
public class DetallePedido {

    @Id
    private String idPedido;

    @Id
    private String idProd;

    private int cantidad;
    private BigDecimal precio;
    private BigDecimal totalDeta;
}
