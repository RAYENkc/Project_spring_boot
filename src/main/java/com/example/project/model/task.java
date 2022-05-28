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
@Table(name="task")

public class task {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  long id;
	
	@NotNull(message="nom_taskshoud not be null")
	@Column(name="nom_task")
	@JsonProperty("nom_task")
	private  String nom_task;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="list_id")
	private list list;
	
	//Commentaire join
	@JsonBackReference
    @OneToMany(mappedBy= "task")
    private List<commentaire> commentaire;
    
	
	

  /*	public void setId(long id) {
		this.id = id;
	}*/

	public void setNom_task(String nom_task) {
		this.nom_task = nom_task;
	}

	public long getId() {
		return id;
	}

	public String getNom_task() {
		return nom_task;
	}

	public list getList() {
		return list;
	}

	public void setList(list list) {
		this.list = list;
	}

	public List<commentaire> getCommentaire() {
		return commentaire;
	}

	public task() {
		
		
	}

	/*public void setCommentaire(List<commentaire> commentaire) {
		this.commentaire = commentaire;
	}*/

	
	
	
	
	
	
}
