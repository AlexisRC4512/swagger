package com.semana7.swagger.service.impl;



import com.semana7.swagger.entity.AutorEntity;
import com.semana7.swagger.repository.AutorRepository;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.service.AutorService;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor sirve para inyectar la dependencia solo para las variable dee final
public class AutorServiceImpl implements AutorService {
    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public AutorEntity createAutor(AutorRequest autor) {
        AutorEntity entity = new AutorEntity();
        entity.setTipoDoc(autor.getTipoDoc());
        entity.setNumDoc(autor.getNumDoc());
        entity.setNombre(autor.getNombre());
        entity.setApellidos(autor.getApellidos());
        entity.setEmail(autor.getEmail());
        entity.setEstado(1);
        entity.setUserCreate("Paul");
        entity.setDateCreate(getTimestamp());

        return autorRepository.save(entity);
    }

    @Override
    public List<AutorEntity> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Override
    public AutorEntity obtenerUno(Integer id) {
        Optional<AutorEntity>autor=autorRepository.findById(id);
        if (autor.isPresent()){
            return autor.get();
        }
            return null;


    }

    @Override
    public AutorEntity actualizar(Integer id, AutorEntity autorEntity) {
        boolean exists=autorRepository.existsById(id);
        if (exists){
            Optional<AutorEntity>entity=autorRepository.findById(id);
            AutorEntity autor=entity.get();
            autor.setNombre(autorEntity.getNombre());
            autor.setApellidos(autorEntity.getApellidos());
            return autorRepository.save(autor);
        }
        return null;
    }

    @Override
    public AutorEntity elminar(Integer id) {
        boolean exists=autorRepository.existsById(id);
        if (exists){
            Optional<AutorEntity>entity=autorRepository.findById(id);
            AutorEntity autor=entity.get();
            autor.setEstado(0);

            return autorRepository.save(autor);
        }
        return null;
    }
    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }
}
