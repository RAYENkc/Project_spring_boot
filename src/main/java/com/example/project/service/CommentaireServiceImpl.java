package com.example.project.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.commentaire;
import com.example.project.model.user;
import com.example.project.repository.commentaireRepository;
import com.example.project.repository.userRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
	  @Autowired 
		private commentaireRepository cRepository;

	@Override
	public List<commentaire> getcommentaire() {
		return cRepository.findAll();
	}

	@Override
	public commentaire getCommentaireId(Long id) {
		Optional<commentaire> User = cRepository.findById(id);
		if(User.isPresent()) {
			return  User.get();
		}
		 throw new RuntimeException(" user not found for id"+ id);
	}

	@Override
	public void deleteCommentaire(Long id) {
		 cRepository.deleteById(id);
	}

	@Override
	public commentaire updatecommentaire(commentaire commentaire) {
		return cRepository.save(commentaire) ;
	}

	@Override
	public commentaire saveCommentaire(@Valid commentaire commentaire) {

		return cRepository.save(commentaire);
	}

}
