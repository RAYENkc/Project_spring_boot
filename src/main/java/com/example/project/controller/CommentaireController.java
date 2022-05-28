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

import com.example.project.model.commentaire;
import com.example.project.model.user;
import com.example.project.service.CommentaireService;
import com.example.project.service.userService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class CommentaireController {
	
	@Autowired
	private CommentaireService cService;
	

	@GetMapping("/commentaires")
	public List<commentaire> getUsers (){
		
		return cService.getcommentaire();
	}
	
	 @GetMapping("/commentaire/{id}")
	    public commentaire getUser (@PathVariable("id") long id) {
	    	return cService.getCommentaireId(id);
	  }
	  @PostMapping("/commentaire")
	    public commentaire  saveUser (@Valid @ModelAttribute("user") commentaire User) {
	       
	    	return cService.saveCommentaire(User);
	  }
	  
	  @PutMapping("/commentaire/{id}")
	    public commentaire updateUser (@PathVariable long id , @RequestBody commentaire User) {
	    	//User.setId(id);
	    	return cService.updatecommentaire(User);
	    }
	    
	    @DeleteMapping("/commentaire")
	    public void deleteUser (@RequestParam("id")long id) {
	    	cService.deleteCommentaire(id);
	    	
	    }
}
