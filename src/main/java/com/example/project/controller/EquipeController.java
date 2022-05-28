package com.example.project.controller;

import java.lang.System.Logger;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.model.Equipe;
import com.example.project.model.user;
import com.example.project.service.EquipeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping()

public class EquipeController {

	@Autowired
	private EquipeService eService;
	
	@GetMapping("/equipes")
	public List<Equipe> getUsers (){
		return eService.getEquipe();
	}
	
	 @GetMapping("/equipe/{id}")
	    public Equipe getSingleEquipe (@PathVariable("id_eq") long id_eq) {
	    	return eService.getSingleEquipe(id_eq);
	    }
	    
	 
	    @PostMapping("/equipe")
	    public Equipe saveEquipe(@RequestBody @Valid   @ModelAttribute Equipe equipe) {
	    	return eService.saveEquipe(equipe);
	    }
	    
	    @PutMapping("/equipe/{id}")
	    public Equipe updateEquipe (@PathVariable long id_eq , @RequestBody Equipe equipe) {
	    	//User.setId(id);
	    	return eService.updateEquipe(equipe);
	    }
	    
	    @DeleteMapping("/equipe")
	    public void deleteEquipe(@RequestParam("id_eq")long id_eq) {
	    	eService.deleteEquipe(id_eq);
	    	
	    }
		
}
