package com.example.project.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity()
@Table(name="list")
public class list {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  long id;
	
	@NotNull(message="nom_task shoud not be null")
	@Column(name="nom")
	private  String nom;

	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private user user;
	
	//Task join
	@JsonManagedReference

    @OneToMany(mappedBy= "list")
    private List<task> tasks;
    
	
	
	
	/*public list(long id, @NotNull(message = "nom shoud not be null") String nom) {
		this.id = id;
		this.nom = nom;
		
		
	}*/

	
	public list() {
		this.nom = "test";
		this.id=12;
	}

	public String getNom() {
		return nom;
	}

	

	public long getUser() {
		return user.getId();
	}
	/*
	 * public void setNom(String nom) {
		this.nom = nom;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
	public long getId() {
		return id;
	}
	

	public void setTasks(List<task> tasks) {
		this.tasks = tasks;
	}*/

	
	
	public List<task> gettasks() {
		return tasks;
	}


	
	
	
}
