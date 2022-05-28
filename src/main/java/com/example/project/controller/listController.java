package com.example.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

import com.example.project.model.list;
import com.example.project.model.user;
import com.example.project.service.listService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class listController {
	
	@Autowired
	private listService lService;
	
	
	@GetMapping("/lists")
	public List<list> getUsers (){
		
		return lService.getNom_list();
	}
	
	 @GetMapping("/list/{id}")
	    public list getUser (@PathVariable("id") long id) {
	    	return lService.getSingleList(id);
	 }
	
	 @PostMapping("/list")
	    public list saveUser (@Valid @ModelAttribute("list") list List) {
	    	
	    	return lService.saveList(List);
	}

	 
	 @PutMapping("/list/{id}")
	    public list updateUser (@PathVariable long id , @RequestBody list List) {
	    	//User.setId(id);
	    	return lService.updateListe(List);
	    }	
	 
	 @DeleteMapping("/list")
	    public void deleteUser (@RequestParam("id")long id) {
	    	lService.deletelist(id);
	    	
	    }
		
}
