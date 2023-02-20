package com.staff.prueba.service;

import com.staff.prueba.entity.Cancion;
import com.staff.prueba.entity.ListaReproduccion;
import com.staff.prueba.repository.CancionRepository;
import com.staff.prueba.repository.ListaRepository;
import jakarta.transaction.Transactional;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionService {
    private final org.apache.juli.logging.Log LOG = LogFactory.getLog(CancionService.class);
    private CancionRepository cancionRepository;
    public CancionService(CancionRepository cancionRepository){
        super();
        this.cancionRepository = cancionRepository;
    }
    @Transactional
    public void saveTransactional(List<Cancion> canciones) {

        canciones.stream().peek(cancion -> LOG.info("cancion insertado " + cancion)).forEach(cancionRepository::save);
    }
    public List<Cancion> getAllCanciones() {
        return (List<Cancion>) cancionRepository.findAll();
    }


    public Cancion save(Cancion newCancion) {
        // TODO Auto-generated method stub
        return cancionRepository.save(newCancion);
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        cancionRepository.delete(new Cancion(id));
    }

    public Cancion update(Cancion newCancion, Long id) {
        // TODO Auto-generated method stub
        return
                cancionRepository.findById(id)
                        .map(
                                cancion -> {
                                    cancion.setArtista(newCancion.getArtista());
                                    cancion.setAlbum(newCancion.getAlbum());
                                    cancion.setTitulo(newCancion.getTitulo());
                                    cancion.setGenero(newCancion.getGenero());
                                    cancion.setAnno(newCancion.getAnno());
                                    return cancionRepository.save(cancion);
                                }
                        ).get();

    }

}
