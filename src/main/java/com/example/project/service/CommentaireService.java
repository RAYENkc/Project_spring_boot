package com.example.project.service;
import java.util.List;

import javax.validation.Valid;

import com.example.project.model.commentaire;

public interface CommentaireService {
	
	List<commentaire> getcommentaire(); 
    commentaire getCommentaireId( Long id );
    
    void deleteCommentaire(Long id);
    
    commentaire updatecommentaire(commentaire commentaire);
    commentaire saveCommentaire(@Valid commentaire commentaire);

}
