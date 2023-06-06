/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Compra;
import com.tendencias.app.Usuarios.model.Rol;
import com.tendencias.app.Usuarios.model.Usuario;
import com.tendencias.app.Usuarios.repository.CompraRepository;
import com.tendencias.app.Usuarios.service.CompraServiceImpl;
import com.tendencias.app.Usuarios.service.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraServiceImpl compraservice;

    @GetMapping("/get")
    public ResponseEntity<List<Compra>> listacompra() {
        return new ResponseEntity<>(compraservice.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Compra> crearcompra(@RequestBody Compra u) {
        return new ResponseEntity<>(compraservice.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Compra> actualizarRol(@PathVariable Integer id, @RequestBody Compra u) {
        Compra c = compraservice.findById(id);
        if (c != null) {
            try {
                c.setNombre(u.getNombre());
                c.setPvp(u.getPvp());

                return new ResponseEntity<>(compraservice.save(c), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
