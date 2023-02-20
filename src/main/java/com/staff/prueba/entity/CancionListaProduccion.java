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
}
