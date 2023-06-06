/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Usuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author 59398
 */
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El usuario no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;

    @Size(min = 10, max = 10, message = "La cedula debe tener 10 caracteres")
    @NotBlank(message = "La Cedula no puede estar en blanco")
    @Column(name = "cedula")
    private String cedula;

    @NotBlank(message = "El Direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;

    @Size(min = 10, max = 10, message = "El telefono debe tener 10 caracteres")
    @NotBlank(message = "El telefono no puede estar en blanco")
    @Column(name = "telefono")
    private String telefono;

    @Email
    @NotBlank(message = "El correo no puede estar en blanco")
    @Column(name = "correo")
    private String correo;

    @NotBlank(message = "El pass no puede estar en blanco")
    @Column(name = "pass")
    private String pass;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Compra> listacompra;
}
