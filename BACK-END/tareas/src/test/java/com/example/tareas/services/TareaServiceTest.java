package com.example.tareas.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import com.example.tareas.models.TareaModel;
import com.example.tareas.repositories.TareaRepository;

public class TareaServiceTest{
    
    @Mock
    private TareaRepository tareaRepository;

    @InjectMocks
    private TareaService tareaService;

    private TareaModel tareaModel;

    private List<TareaModel> ListTareas;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        tareaModel = new TareaModel();
        tareaModel.setDescripcion("descripcion");
        Date date = new Date();
        tareaModel.setFechaCreacion(date);
        tareaModel.setIdentificador(Long.parseLong("2"));
        tareaModel.setVigente(true);
    }

    @Test
    void listarTareas(){
        when(tareaRepository.findAll()).thenReturn(ListTareas);
        assertNotNull(tareaService.listarTareas());
    }

    @Test
    void guardarTareas(){
        when(tareaRepository.save(tareaModel)).thenReturn(tareaModel);
        assertNotNull(tareaService.guardarTareas(tareaModel));
    }

    @Test
    void eliminarTarea(){
        Mockito.doThrow(new Exception()).doNothing().when(tareaRepository).deleteById(tareaModel.getIdentificador());
        assertNotNull(tareaService.eliminarTarea(tareaModel.getIdentificador()));
    }

    @Test
    void editarTarea(){
        when(tareaRepository.save(tareaModel)).thenReturn(tareaModel);
        assertNotNull(tareaService.listarTareas());
    }

}