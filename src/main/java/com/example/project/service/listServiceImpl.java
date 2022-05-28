package com.example.project.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.list;
import com.example.project.model.user;
import com.example.project.repository.listRepository;
import com.example.project.repository.userRepository;

@Service
public class listServiceImpl implements listService {
	 @Autowired 
		private listRepository lRepository;
	
	@Override
	public List<list> getNom_list() {
		
		return  lRepository.findAll();
	}

	@Override
	public Long getListId(Long id) {
		
		return null;
	}

	@Override
	public void deletelist(Long id) {
		lRepository.deleteById(id);
		
	}

	@Override
	public list updateListe(list list) {
	
		return lRepository.save(list) ;
	}

	@Override
	public List<list> getlistBynom(String nom) {
		
		return null;
	}

	@Override
	public list saveList(list List) {
		
		return lRepository.save(List) ;	}

	@Override
	public list getSingleList(long id) {
		Optional<list> List = lRepository.findById(id);
		if(List.isPresent()) {
			return  List.get();
		}
		 throw new RuntimeException(" List not found for id"+ id);
	}

}
