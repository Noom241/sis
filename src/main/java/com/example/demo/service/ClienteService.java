package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardar(Cliente cliente) {
        // Obtener el último idCliente
        String ultimoIdCliente = obtenerUltimoIdCliente(); // Llamada al método del repositorio
        
        // Generar un nuevo idCliente si no hay clientes o el último id está vacío
        String nuevoIdCliente = generarNuevoIdCliente(ultimoIdCliente);
        cliente.setIdCliente(nuevoIdCliente); // Asignar el nuevo idCliente al cliente
        
        return clienteRepository.save(cliente);  // Guardar el cliente en la base de datos
    }

    private String obtenerUltimoIdCliente() {
        List<String> resultado = clienteRepository.obtenerUltimoIdCliente();
        return resultado.isEmpty() ? null : resultado.get(0);  // Si la lista está vacía, devolver null
    }

    private String generarNuevoIdCliente(String ultimoIdCliente) {
        if (ultimoIdCliente == null || ultimoIdCliente.isEmpty()) {
            return "C00001";  // Si no hay clientes, iniciar con C00001.
        }

        // Extraer el número del último ID, incrementarlo y formar el nuevo ID
        String numero = ultimoIdCliente.substring(1);  // Obtener la parte numérica del ID (por ejemplo "00001")
        int nuevoNumero = Integer.parseInt(numero) + 1;  // Convertirlo a entero y sumarle 1

        // Crear el nuevo ID con el formato adecuado
        return "C" + String.format("%05d", nuevoNumero);  // Esto asegura que el ID tenga 5 dígitos, como "C00002"
    }

    // Método para listar todos los clientes
    public List<Cliente> listar() {
        return clienteRepository.findAll();  // Obtiene todos los clientes desde la base de datos
    }
}
