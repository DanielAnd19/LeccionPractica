/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Productos;
import com.tendencias.app.Usuarios.model.Usuario;
import com.tendencias.app.Usuarios.service.ProductoServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Danie
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl prodservice;

    @GetMapping("/get")
    public ResponseEntity<List<Productos>> listaprod() {
        return new ResponseEntity<>(prodservice.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Productos> crearProducto(@RequestBody Productos u) {
        return new ResponseEntity<>(prodservice.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Productos> actualizaProducto(@PathVariable Integer id, @RequestBody Productos u) {
        Productos p = prodservice.findById(id);
        if (p != null) {
            try {
                p.setNombre(u.getNombre());
                p.setDescripcion(u.getDescripcion());
                p.setCategoria(u.getCategoria());
                p.setPrecio(u.getPrecio());
                p.setAdicional(u.getAdicional());
                p.setCant(u.getCant());

                return new ResponseEntity<>(prodservice.save(p), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Productos> eliminarProducto(@PathVariable Integer id) {
        prodservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
