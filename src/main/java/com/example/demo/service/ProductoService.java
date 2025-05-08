package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        String ultimoIdProducto = obtenerUltimoIdProducto();
        String nuevoIdProducto = generarNuevoIdProducto(ultimoIdProducto);
        producto.setIdProducto(nuevoIdProducto);

        return productoRepository.save(producto);
    }

    private String obtenerUltimoIdProducto() {
        List<String> resultado = productoRepository.obtenerUltimoIdProducto();
        return resultado.isEmpty() ? null : resultado.get(0);
    }

    private String generarNuevoIdProducto(String ultimoIdProducto) {
        if (ultimoIdProducto == null || ultimoIdProducto.isEmpty()) {
            return "P0001";  // Si no hay productos, iniciar con P00001
        }

        String numero = ultimoIdProducto.substring(1);  // Quitar la "P"
        int nuevoNumero = Integer.parseInt(numero) + 1;

        return "P" + String.format("%04d", nuevoNumero);  // Formato P00001
    }
}
