package com.example.demo.controller;

import com.example.demo.model.DetallePedido;
import com.example.demo.repository.DetallePedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetallePedidoController {

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoController(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @GetMapping("/{idPedido}")
    public List<DetallePedido> getDetallesPorPedido(@PathVariable String idPedido) {
        return detallePedidoRepository.findDetallesPorIdPedido(idPedido);
    }
}
