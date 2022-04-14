package com.example.tareas.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tarea")
public class TareaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long identificador;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Date fechaCreacion;
    @Column(nullable = false)
    private Boolean vigente;

    public TareaModel() {
        super();
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
}
