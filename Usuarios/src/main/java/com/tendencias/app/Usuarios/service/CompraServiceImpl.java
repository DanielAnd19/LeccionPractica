/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Usuarios.service;

import com.tendencias.app.Usuarios.model.Compra;
import com.tendencias.app.Usuarios.repository.CompraRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Danie
 */
@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, Integer> implements GenericService<Compra, Integer> {

    @Autowired
    CompraRepository comprarepository;

    @Override
    public CrudRepository<Compra, Integer> getDao() {
        return comprarepository;

    }

}
