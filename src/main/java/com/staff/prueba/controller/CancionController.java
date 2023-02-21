package com.staff.prueba.controller;

import com.staff.prueba.entity.Cancion;
import com.staff.prueba.entity.ListaReproduccion;
import com.staff.prueba.repository.ListaRepository;
import com.staff.prueba.service.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CancionController {
    @Autowired
    ListaRepository listaRepository;

    @Autowired
    private CancionService cancionService;

    @PostMapping("/canciones")
    public ResponseEntity<Cancion> save(@RequestBody Cancion cancion) {
        Optional<ListaReproduccion> listaReproduccionOptional = listaRepository.findById(cancion.getListaReproduccion().getId());
        if (!listaReproduccionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        cancion.setListaReproduccion(listaReproduccionOptional.get());
        Cancion cancionGuardado = cancionService.save(cancion);
        return new ResponseEntity(cancionGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/canciones")
    public List<Cancion> getAll() {
        return cancionService.getAllCanciones();
    }

}
