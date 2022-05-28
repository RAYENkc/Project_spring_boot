package com.example.project.model;



import com.fasterxml.jackson.annotation.JsonIgnore;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;





@Entity()
@Table(name="Equipe")

public class Equipe {
	
	
	@Id()
	@Column(name="id_eq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_eq;
	
	
	@NotNull(message="NameEq shoud not be null")
	@Column(name="NameEq")
	private  String NameEq;

    @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            },
	mappedBy = "Equipes")
   // @JsonIgnore
    private Set<user> users = new HashSet<>();

	public long getId_eq() {
		return id_eq;
	}

	public void setId_eq(long id) {
		this.id_eq = id;
	}

	public String getNameEq() {
		return NameEq;
	}

	public void setNameEq(String nameEq) {
		NameEq = nameEq;
	}

	public Set<user> getUsers() {
		return users;
	}

	public void setUsers(Set<user> users) {
		this.users = users;
	}

	public Equipe() {
		this.id_eq = 0;
		this.NameEq = "";
	}
	
	
	public Equipe(long id, @NotNull(message = "NameEq shoud not be null") String nameEq) {
		super();
		this.id_eq = id;
		NameEq = nameEq;
	}
    

}
