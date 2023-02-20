package com.staff.prueba.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cancionlistaproduccion")
public class CancionListaProduccion {
    @EmbeddedId CancionListaProduccionPK id;
    
    @ManyToOne
    @JoinColumn(name = "id_cancion",insertable = false,updatable = false)
    private  Cancion cancion;

    @ManyToOne
    @JoinColumn(name = "id_lista_reproduccion",insertable = false, updatable = false)
    private ListaReproduccion listaReproduccion;

    public CancionListaProduccionPK getId() {
        return id;
    }

    public void setId(CancionListaProduccionPK id) {
        this.id = id;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public ListaReproduccion getListaReproduccion() {
        return listaReproduccion;
    }

    public void setListaReproduccion(ListaReproduccion listaReproduccion) {
        this.listaReproduccion = listaReproduccion;
    }
}
