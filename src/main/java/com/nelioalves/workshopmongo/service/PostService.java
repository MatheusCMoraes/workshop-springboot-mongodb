package com.nelioalves.workshopmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {

		Post post = repo.findById(id).orElse(null);
		// uso do orElse por conta da implementação interna do Optional

		if (post == null) {

			throw new ObjectNotFoundException("Objeto não encontrado.");
		}

		return post;

	}
}
