package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT c.idCliente FROM Cliente c ORDER BY c.idCliente DESC")
    List<String> obtenerUltimoIdCliente();
}
