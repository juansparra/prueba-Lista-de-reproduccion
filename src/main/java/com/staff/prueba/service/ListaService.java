package com.staff.prueba.service;

import com.staff.prueba.entity.ListaReproduccion;
import com.staff.prueba.repository.ListaRepository;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {
    private final org.apache.juli.logging.Log LOG = LogFactory.getLog(ListaService.class);
    private ListaRepository listaRepository;
    public ListaService(ListaRepository listaRepository){
        super();
        this.listaRepository = listaRepository;
    }
    @Transactional
    public void saveTransactional(List<ListaReproduccion> listasReproduccion) {

        listasReproduccion.stream().peek(listaReproduccion -> LOG.info("lista insertada " + listaReproduccion)).forEach(listaRepository::save);
    }

    public List<ListaReproduccion> getAllListas() {

        return (List<ListaReproduccion>) listaRepository.findAll();
    }

    public ListaReproduccion save(ListaReproduccion newListaReproduccion) {
        return listaRepository.save(newListaReproduccion);
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        listaRepository.delete(new ListaReproduccion(id));
    }

    public ListaReproduccion update(ListaReproduccion newListaReproduccion, Long id) {
        // TODO Auto-generated method stub
        return
                listaRepository.findById(id)
                        .map(
                                listaReproduccion -> {
                                    listaReproduccion.setNombre(newListaReproduccion.getNombre());
                                    listaReproduccion.setDescripcion(newListaReproduccion.getDescripcion());
                                    listaReproduccion.setCanciones(newListaReproduccion.getCanciones());

                                    return listaRepository.save(listaReproduccion);
                                }
                        ).get();

    }

}
