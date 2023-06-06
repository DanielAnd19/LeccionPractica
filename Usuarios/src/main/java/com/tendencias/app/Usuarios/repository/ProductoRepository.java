/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Usuarios.repository;

import com.tendencias.app.Usuarios.model.Productos;
import com.tendencias.app.Usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Danie
 */
public interface ProductoRepository extends JpaRepository<Productos, Integer>{
        @Query(value = "Select * from productos u where u.nombre = :nombre", nativeQuery = true)
    public Usuario buscarUsuario(String nombre);    
}
