package com.staff.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CancionListaProduccionPK implements Serializable {
    @Column(name = "id_cancion")
    private long idCancion;
    @Column(name = "id_lista_reproduccion")
    private  long idListaReproduccion;

    public long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(long idCancion) {
        this.idCancion = idCancion;
    }

    public long getIdListaReproduccion() {
        return idListaReproduccion;
    }

    public void setIdListaReproduccion(long idListaReproduccion) {
        this.idListaReproduccion = idListaReproduccion;
    }
}
