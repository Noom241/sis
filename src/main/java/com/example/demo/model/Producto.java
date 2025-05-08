package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_producto")
@Data
public class Producto {
    @Id
    @Column(name = "id_prod")
    private String idProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "cantidad")
    private int cantidad;
}
