package com.gabrielsantana.workshopmongo.services;

import com.gabrielsantana.workshopmongo.domain.Post;
import com.gabrielsantana.workshopmongo.repository.PostRepository;
import com.gabrielsantana.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post with id" +  id + " not found"));

        return post;
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
