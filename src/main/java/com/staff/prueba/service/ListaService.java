package com.staff.prueba.service;

import com.staff.prueba.entity.ListaReproduccion;
import com.staff.prueba.repository.ListaRepository;

import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<ListaReproduccion> getById(Long id){
        return listaRepository.findById(id);
    }
    public ListaReproduccion save(ListaReproduccion newListaReproduccion) {
        return listaRepository.save(newListaReproduccion);
    }

    public void deleteByNombre (String nombre){
        listaRepository.deleteByNombre(nombre);
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        listaRepository.delete(new ListaReproduccion(id));
    }

    @Transactional(readOnly = true)
    public Optional<ListaReproduccion> getLista(String nombre){
        return listaRepository.findBynombre(nombre);
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
