package com.example.tareas.repositories;

import com.example.tareas.models.TareaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Long> {
    
}