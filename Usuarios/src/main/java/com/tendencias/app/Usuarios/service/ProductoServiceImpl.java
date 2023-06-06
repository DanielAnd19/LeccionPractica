/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Productos;
import com.tendencias.app.Usuarios.repository.ProductoRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Danie
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Productos, Integer> implements GenericService<Productos, Integer> {

    @Autowired
    ProductoRepository prodrepository;

    @Override
    public CrudRepository<Productos, Integer> getDao() {

        return prodrepository;
    }

}
