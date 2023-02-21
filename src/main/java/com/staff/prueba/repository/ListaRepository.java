package com.staff.prueba.repository;

import com.staff.prueba.entity.Cancion;
import com.staff.prueba.entity.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ListaRepository extends PagingAndSortingRepository<ListaReproduccion,Long>, JpaRepository <ListaReproduccion, Long>, CrudRepository<ListaReproduccion,Long> {
    @Query("from Cancion")
    public List<Cancion> findAllCanciones();

    @Query("select lista.descripcion from ListaReproduccion lista where lista.nombre =?1")
    Optional<ListaReproduccion> findBynombre(String nombre);
    @Transactional
    public void deleteByNombre(String nombre);



}
