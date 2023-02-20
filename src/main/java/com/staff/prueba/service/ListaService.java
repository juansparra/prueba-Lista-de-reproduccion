package com.staff.prueba.service;

import com.staff.prueba.entity.Cancion;
import com.staff.prueba.entity.ListaReproduccion;
import com.staff.prueba.repository.ListaRepository;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {
    private final org.apache.juli.logging.Log LOG = LogFactory.getLog(CancionService.class);
 private ListaRepository listaRepository;

 public ListaService (ListaRepository listaRepository){
     super();
     this.listaRepository = listaRepository;
 }
    @Transactional
    public void saveTransactional(List<ListaReproduccion> listasReproduccion) {

        listasReproduccion.stream().peek(listaReproduccion -> LOG.info("lista de reproduccion insertado " + listaReproduccion)).forEach(listaRepository::save);
    }

    public List<ListaReproduccion> getAllListasReproduccion() {
        return (List<ListaReproduccion>) listaRepository.findAll();
    }

    public ListaReproduccion save(ListaReproduccion newListaReproduccion) {
        // TODO Auto-generated method stub
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
                                    listaReproduccion.setArtista(newCancion.getArtista());
                                    listaReproduccion.setAlbum(newCancion.getAlbum());
                                    listaReproduccion.setTitulo(newCancion.getTitulo());
                                    listaReproduccion.setGenero(newCancion.getGenero());
                                    listaReproduccion.setAnno(newCancion.getAnno());
                                    return cancionRepository.save(cancion);
                                }
                        ).get();

    }
}
