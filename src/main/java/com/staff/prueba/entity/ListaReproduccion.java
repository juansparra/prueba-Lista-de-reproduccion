package com.staff.prueba.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "listasreproduccion")
public class ListaReproduccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_lista_reproduccion")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    @OneToMany (mappedBy = "listaReproduccion" , fetch = FetchType.LAZY)
    private List<Cancion> canciones;

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

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
