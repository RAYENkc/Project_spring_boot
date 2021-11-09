package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Equipe;
import com.example.project.model.user;


@Repository
public interface equipeRepository extends JpaRepository<Equipe, Long > {

	
	
}
