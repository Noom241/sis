package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public List<Pedido> listar() {
        return repo.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        // Generar ID si no lo trae (por ejemplo, en POST desde frontend)
        if (pedido.getIdPedido() == null || pedido.getIdPedido().isEmpty()) {
            String ultimoId = obtenerUltimoIdPedido();
            String nuevoId = generarNuevoIdPedido(ultimoId);
            pedido.setIdPedido(nuevoId);
        }
        return repo.save(pedido);
    }

    private String obtenerUltimoIdPedido() {
        List<String> resultado = repo.obtenerUltimoIdPedido();
        return resultado.isEmpty() ? null : resultado.get(0);
    }

    private String generarNuevoIdPedido(String ultimoId) {
        if (ultimoId == null || ultimoId.isEmpty()) {
            return "P0001"; // Prefijo PD (Pedido)
        }

        String numero = ultimoId.substring(2); // Quitar el "PD"
        int nuevoNumero = Integer.parseInt(numero) + 1;
        return "PD" + String.format("%04d", nuevoNumero);
    }

    public Pedido obtenerPorId(String id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }
}
