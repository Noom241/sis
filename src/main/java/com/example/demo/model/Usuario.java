package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "t_usuario")  // Asegúrate de usar el nombre correcto
public class Usuario {

    @Id
    @Column(name = "id_usuario") // nombre exacto en tu tabla
    private String idUsuario;

    @Column(name = "passwd") // nombre exacto en tu tabla
    private String passwd;

    // Getters y Setters

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
