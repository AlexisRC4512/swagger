package com.semana7.swagger.entity;





import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer id;
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @Column(name = "num_doc")
    private String numDoc;
    private String nombre;
    private String apellidos;
    private String email;
    private int estado;
    @Column(name = "user_create")
    private String userCreate;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "user_modif")
    private String userModif;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @Column(name = "user_delete")
    private String userDelete;
    @Column(name = "date_delete")
    private Timestamp dateDelete;
}
