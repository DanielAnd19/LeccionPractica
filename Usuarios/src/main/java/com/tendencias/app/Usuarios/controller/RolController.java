/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Usuarios.controller;

import com.tendencias.app.Usuarios.model.Rol;
import com.tendencias.app.Usuarios.model.Usuario;
import com.tendencias.app.Usuarios.service.RolServiceImpl;
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
@RequestMapping("/rol")
public class RolController {

    @Autowired
    RolServiceImpl rolservice;

    @GetMapping("/get")
    public ResponseEntity<List<Rol>> listaRol() {
        return new ResponseEntity<>(rolservice.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol u) {
        return new ResponseEntity<>(rolservice.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol u) {
        Rol r = rolservice.findById(id);
        if (r != null) {
            try {
                r.setNombre(u.getNombre());

                return new ResponseEntity<>(rolservice.save(r), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> eliminarRol(@PathVariable Integer id) {
        rolservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
