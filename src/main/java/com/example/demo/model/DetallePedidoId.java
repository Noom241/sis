package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class DetallePedidoId implements Serializable {
    private String idPedido;
    private String idProd;

    // Constructor vacío obligatorio
    public DetallePedidoId() {}

    public DetallePedidoId(String idPedido, String idProd) {
        this.idPedido = idPedido;
        this.idProd = idProd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePedidoId)) return false;
        DetallePedidoId that = (DetallePedidoId) o;
        return Objects.equals(idPedido, that.idPedido) &&
               Objects.equals(idProd, that.idProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idProd);
    }
}
