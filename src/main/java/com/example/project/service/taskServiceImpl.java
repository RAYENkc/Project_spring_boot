package com.example.project.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.task;
import com.example.project.model.user;
import com.example.project.repository.taskRepository;
import com.example.project.repository.userRepository;

@Service
public class taskServiceImpl implements taskService  {

	 @Autowired 
		private taskRepository tRepository;
	
	@Override
	public List<task> getNom_task() {
		
		return tRepository.findAll();
	}

	@Override
	public task getTaskId(Long id) {
		
		Optional<task> Task = tRepository.findById(id);
		if(Task.isPresent()) {
			return  Task.get();
		}
		 throw new RuntimeException(" task not found for id"+ id);
	}

	@Override
	public void deletetask(Long id) {
		
		 tRepository.deleteById(id);
	}

	@Override
	public task updatetask(task task) {
		return tRepository.save(task) ;
	}

	@Override
	public List<task> gettaskBynom(String nom) {
		
		return null;
	}

	@Override
	public void savetask(task task) {
		tRepository.save(task);
		
	}
	

}
