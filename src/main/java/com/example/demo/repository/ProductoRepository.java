package com.example.demo.repository;

import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, String> {

    @Query("SELECT p.idProducto FROM Producto p ORDER BY p.idProducto DESC")
    List<String> obtenerUltimoIdProducto();
}
