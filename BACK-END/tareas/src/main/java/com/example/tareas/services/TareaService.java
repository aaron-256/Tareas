package com.example.tareas.services;

import java.util.ArrayList;

import com.example.tareas.models.TareaModel;
import com.example.tareas.repositories.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public ArrayList<TareaModel> listarTareas() {
        return (ArrayList<TareaModel>) tareaRepository.findAll();
    }

    public TareaModel guardarTareas(TareaModel tarea) {
        return tareaRepository.save(tarea);
    }

    public boolean eliminarTarea(Long id) {
        try{
            tareaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public TareaModel editarTarea(TareaModel tarea) {
        return tareaRepository.save(tarea);
    }

}