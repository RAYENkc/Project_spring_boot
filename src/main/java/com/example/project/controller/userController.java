package com.example.project.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.example.project.model.user;
import com.example.project.service.userService;

@RestController
@RequestMapping()
public class userController {

	private static final String template =" hello";
	private final AtomicLong counter = new AtomicLong();
	
	// 
	@Autowired
	private userService uService;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails () {
		return appName+" - "+appVersion;
	}
	
	
	
	@GetMapping("/users")
	public List<user> getUsers (){
		return uService.getUser();
	}
	
	@GetMapping("/user")
	public user user(@RequestParam(value="name", defaultValue="Word") String name) {
		return new user(counter.incrementAndGet(),String.format(template, name),String.format(template, name),String.format(template, name),String.format(template, name));
	}

    @GetMapping("/user/{id}")
    public user getUser (@PathVariable("id") long id) {
    	return uService.getSingleUser(id);
    }
    
    
    @PostMapping("/user")
    public user saveUser (@Valid @ModelAttribute("user") user User) {
    	return uService.saveUser(User);
    }
    @PutMapping("/user/{id}")
    public user updateUser (@PathVariable long id , @RequestBody user User) {
    	//User.setId(id);
    	return uService.updateUser(User);
    }
    
    @DeleteMapping("/user")
    public void deleteUser (@RequestParam("id")long id) {
    	uService.deleteEmployee(id);
    	
    }
	
    @GetMapping("/user/filterByNom")
    public List<user> getUserByNom( @RequestParam String nom){
    	return  uService.getUserBynom(nom);
    }
 

}