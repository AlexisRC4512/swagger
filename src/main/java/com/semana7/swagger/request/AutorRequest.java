package com.semana7.swagger.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorRequest {
    private Integer id;

    private String tipoDoc;

    private String numDoc;
    private String nombre;
    private String apellidos;
    private String email;
}
