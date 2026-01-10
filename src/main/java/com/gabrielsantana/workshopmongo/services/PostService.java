package com.gabrielsantana.workshopmongo.services;

import com.gabrielsantana.workshopmongo.domain.Post;
import com.gabrielsantana.workshopmongo.repository.PostRepository;
import com.gabrielsantana.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post with id" +  id + " not found"));

        return post;
    }
}
