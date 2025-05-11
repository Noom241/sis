package com.example.demo.service;

import com.example.demo.model.DetallePedido;
import com.example.demo.model.DetallePedidoId;
import com.example.demo.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    public List<DetallePedido> listar() {
        return repository.findAll();
    }

    public Optional<DetallePedido> obtenerPorId(String idPedido, String idProd) {
        DetallePedidoId id = new DetallePedidoId(idPedido, idProd);
        return repository.findById(id);
    }

    public List<DetallePedido> obtenerPorIdPedido(String idPedido) {
        return repository.findDetallesPorIdPedido(idPedido);
    }
}
