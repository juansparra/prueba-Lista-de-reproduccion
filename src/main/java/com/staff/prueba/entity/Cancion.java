package com.staff.prueba.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Year;

@Entity
@Table(name = "canciones")
public class Cancion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cancion")
    private long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String artista;
    @Column(length = 50)
    private String album;
    private Integer anno;
@ManyToOne
@JoinColumn(name ="lista_reproduccion_id")
    private ListaReproduccion listaReproduccion;

    public ListaReproduccion getListaReproduccion() {
        return listaReproduccion;
    }

    public void setListaReproduccion(ListaReproduccion listaReproduccion) {
        this.listaReproduccion = listaReproduccion;
    }

    private String genero;

    public Cancion(Long id) {
        this.id = id;
    }

    public Cancion() {

    }

    public Cancion(long id, String titulo, String artista, String album, Integer anno, ListaReproduccion listaReproduccion, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anno = anno;
        this.listaReproduccion = listaReproduccion;
        this.genero = genero;
    }

    public Cancion(String titulo, String artista, String album, Integer anno, ListaReproduccion listaReproduccion, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anno = anno;
        this.listaReproduccion = listaReproduccion;
        this.genero = genero;
    }

    public Cancion(String titulo) {
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
