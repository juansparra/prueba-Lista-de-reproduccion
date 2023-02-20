package com.staff.prueba.repository;

import com.staff.prueba.entity.Cancion;
import com.staff.prueba.entity.ListaReproduccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ListaRepository extends PagingAndSortingRepository<ListaReproduccion,Long>, CrudRepository<ListaReproduccion,Long> {
    @Query("from Cancion")
    public List<Cancion> findAllCanciones();
}
