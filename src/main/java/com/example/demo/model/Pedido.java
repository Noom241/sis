package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_pedido") // Asegúrate que el nombre de la tabla es correcto
@Data
public class Pedido {

    @Id
    @Column(name = "id_pedido") // columna exacta en la base de datos
    private String idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente") // columna que hace la FK en t_pedido
    private Cliente cliente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "subtotal") // si en la BD está como "SubTotal", usa "sub_total" si es snake_case
    private BigDecimal subTotal;

    @Column(name = "totalventa") // o "total_venta" según cómo esté escrito
    private BigDecimal totalVenta;
}
