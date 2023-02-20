package com.staff.prueba.repository;

import com.staff.prueba.entity.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ListaRepository extends PagingAndSortingRepository<Cancion,Long>, CrudRepository<Cancion,Long> {
}
