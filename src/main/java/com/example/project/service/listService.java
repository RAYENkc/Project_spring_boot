package com.example.project.service;import java.util.List;

import javax.validation.Valid;

import com.example.project.model.list;
import com.example.project.model.user;


public interface listService {
	List<list> getNom_list();
	 
    Long  getListId( Long id );
    list getSingleList(long id);
    
    list saveList(@Valid list List);
    
    void deletelist(Long id);
    
    list updateListe(list list);
    
    List<list> getlistBynom(String nom);
}
