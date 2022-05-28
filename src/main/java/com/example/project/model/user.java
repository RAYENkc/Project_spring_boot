package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;


@Entity()
@Table(name="user")
public class user {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  long id;
	
	//@NotNull(message="nom shoud not be null")
	@Column(name="nom")
	@JsonProperty("full_name")
    @NotNull
	private String nom;
	
	//@NotNull(message="prenom shoud not be null")
	@Column(name="prenom")
	private String prenom;
	
	//@NotNull(message="tel shoud not be null")
	@Column(name="tel")
	private  String tel;
	
	//@NotNull(message="Mail shoud not be null")
	@Column(name="mail")
	private String mail;
	
	
	
    //equipe join
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })  
   
    @JoinTable(name = "User_Equipe",
            joinColumns = { @JoinColumn(name = "id_eq")},
            inverseJoinColumns = { @JoinColumn(name = "id_user") })
    private List<Equipe> Equipes;
    
    
    
    
    //list join
    @OneToMany(mappedBy= "user")
    private List<list> lists;
    
    
    
    
  //Commentaire join
    @OneToMany(mappedBy= "user_comm")
    private List<commentaire> commentaires;
    
  /*  public void addEquipe(Equipe Equipe) {
        this.Equipes.add(Equipe);
        
    }*/
	
	/*public user(long id, String nom, String prenom, String tel, String mail) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
	}*/

	public long getId() {
		return id;
	}

/*	public user() {
		this.id = 0;
		this.nom = "";
		this.prenom = "";
		this.tel = "";
		this.mail = "";
		
	}*/
	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<list> getLists() {
		return lists;
	}

	public void setLists(List<list> lists) {
		this.lists = lists;
	}

	public List<commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getTel() {
		return tel;
	}

	public String getMail() {
		return mail;
	}
	
	public List<Equipe> getEquipes() {
	        return Equipes;
	  }

	public void setEquipes(List<Equipe> Equipes) {
	        this.Equipes = Equipes;
	   }
	
public user(long id, String nom, String prenom, String tel, String mail) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
	}

public user() {
	this.id = 0;
	this.nom = "";
	this.prenom = "";
	this.tel = "";
	this.mail = "";
	
}

	

}
