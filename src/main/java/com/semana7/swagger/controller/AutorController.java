package com.semana7.swagger.controller;

import com.semana7.swagger.entity.AutorEntity;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;
    @GetMapping()
    public List<AutorEntity> listaAutores()
    {
        List<AutorEntity> autores=autorService.obtenerTodos();
        return autores;
    }
    @GetMapping("/{id}")
    public AutorEntity listaAutor(@PathVariable Integer id)
    {
        AutorEntity autor=autorService.obtenerUno(id);
        return autor;
    }
    @PostMapping ()
    public AutorEntity crearAutor(@RequestBody AutorRequest autor)
    {
        AutorEntity autorCreado=autorService.createAutor(autor);
        return autorCreado;
    }
    @PutMapping()
    public AutorEntity actualizarAutor(@PathVariable Integer id,@RequestBody AutorEntity autor)
    {
        AutorEntity autorCreado=autorService.actualizar(id,autor);
        return autorCreado;
    }
    @DeleteMapping()
    public AutorEntity eliminarAutor(@PathVariable Integer id)
    {
        AutorEntity autorEliminado=autorService.elminar(id);
        return autorEliminado;
    }
}
