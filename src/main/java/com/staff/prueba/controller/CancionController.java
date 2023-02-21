package com.staff.prueba.controller;

import com.staff.prueba.entity.Cancion;
import com.staff.prueba.entity.ListaReproduccion;
import com.staff.prueba.service.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CancionController {
    @Autowired
   private CancionService cancionService;
    @PostMapping("/canciones")
    public Cancion save(@RequestBody Cancion cancion){
        return cancionService.save(cancion);
    }
    @GetMapping("/canciones")
    public List<Cancion> getAll(){
        return cancionService.getAllCanciones();
    }

}
