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
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Danie
 */
@Data
@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "if_producto")
    private int if_producto;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank(message = "La categoria no puede estar en blanco")
    @Column(name = "categoria")
    private String categoria;

    @NotBlank(message = "El precio no puede estar en blanco")
    @Column(name = "precio")
    private int precio;

    @Column(name = "adicional")
    private String adicional;

    @NotBlank(message = "La cantidad no puede estar en blanco")
    @Column(name = "cant")
    private int cant;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<Compra> listapro;
}
