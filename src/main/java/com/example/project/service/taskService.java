package com.example.project.service;



import java.util.List;

import javax.validation.Valid;

import com.example.project.model.task;


public interface taskService {
	List<task> getNom_task();
	 
    task getTaskId( Long id );
    void savetask( @Valid task task);
    
    void deletetask(Long id);
    
    task updatetask(task task);
    
    List<task> gettaskBynom(String nom);
}
