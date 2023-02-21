package com.staff.prueba.repository;

import com.staff.prueba.entity.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionRepository extends PagingAndSortingRepository<Cancion,Long> , CrudRepository<Cancion,Long> {
    Cancion save (Cancion cancion);
}
