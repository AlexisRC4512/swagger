package com.semana7.swagger.service;

import com.semana7.swagger.entity.AutorEntity;
import com.semana7.swagger.request.AutorRequest;

import java.util.List;

public interface AutorService {
    AutorEntity createAutor(AutorRequest autor);

    List<AutorEntity>obtenerTodos();
    AutorEntity obtenerUno(Integer id);
    AutorEntity actualizar(Integer id,AutorEntity autorEntity);
    AutorEntity elminar(Integer id);
}
