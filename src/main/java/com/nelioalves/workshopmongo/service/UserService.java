package com.nelioalves.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	
	public List<User> findAll(){
		
		
		return repo.findAll();
		
	}
	
	
	public User findById(String id) {
		
		User user =  repo.findById(id).orElse(null); //uso do orElse por conta da implementação interna do Optional	
		
		if(user == null) {
			
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		
		return user;
		
	}
}
