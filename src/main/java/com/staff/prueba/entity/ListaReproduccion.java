package com.staff.prueba.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "listasreproduccion")
public class ListaReproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_reproduccion")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "listaReproduccion", cascade = CascadeType.ALL)
    private Set<Cancion> canciones = new HashSet<>();

    public ListaReproduccion(Long id) {
    }

    public ListaReproduccion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
        for (Cancion cancion : canciones) {
            cancion.setListaReproduccion(this);
        }
    }

}
