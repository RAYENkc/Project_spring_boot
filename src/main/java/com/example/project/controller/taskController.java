package com.example.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.task;
import com.example.project.model.user;
import com.example.project.service.taskService;
import com.example.project.service.userService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class taskController {
	
	@Autowired
	private taskService tService;
	
	@GetMapping("/tasks")
	public List<task> gettasks(){
		
		return tService.getNom_task();
	}
	
	@GetMapping("/task/{id}")
	 public task getUser (@PathVariable("id") long id) {
	    	return tService.getTaskId(id);
	  }
	
	 @PostMapping("/task")
	    public void saveUser (@Valid @RequestBody @ModelAttribute("user")task task) {
	       
	    	 tService.savetask(task);
	 }
	 
	 @PutMapping("/task/{id}")
	    public task updateUser (@PathVariable long id , @RequestBody task task) {
	    	//User.setId(id);
	    	return tService.updatetask(task);
	    }
	   
	  @DeleteMapping("/task")
	    public void deleteUser (@RequestParam("id")long id) {
	    	tService.deletetask(id);
	    	
	    }
}
