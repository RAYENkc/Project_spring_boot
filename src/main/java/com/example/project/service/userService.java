package com.example.project.service;

import java.util.List;

import com.example.project.model.Equipe;
import com.example.project.model.user;

public interface userService {
	
	List<user> getUser();
    
	user saveUser(user User);
	
	user getSingleUser(Long id);
	
	void deleteEmployee(Long id);
	
	user updateUser(user User);
	
	List<user> getUserBynom(String nom);
	void addEquipeToUser(long id, Equipe equipe);
	/*List<user> getUserByNameandTel(String nom,String tel);
	*/
}
