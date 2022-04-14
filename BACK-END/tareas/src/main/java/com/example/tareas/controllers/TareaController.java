package com.example.tareas.controllers;

import java.util.ArrayList;

import com.example.tareas.models.TareaModel;
import com.example.tareas.services.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping("/list")
    public ArrayList<TareaModel> listarTareas() {
        return tareaService.listarTareas();
    }
    @PostMapping("/save")
    public TareaModel guardarTareas(@RequestBody TareaModel tarea) {
        return tareaService.guardarTareas(tarea);
    }

    @DeleteMapping( path = "/delete/{id}")
    public String eliminarTarea(@PathVariable("id") Long id) {
        boolean ok = tareaService.eliminarTarea(id);
        if (ok){
            return "Se eliminó la Tarea con id " + id;
        }else{
            return "No pudo eliminar la Tarea con id" + id;
        }
    }

    @PostMapping("/update")
    public TareaModel ediatrTareas(@RequestBody TareaModel tarea) {
        return tareaService.editarTarea(tarea);
    }
}