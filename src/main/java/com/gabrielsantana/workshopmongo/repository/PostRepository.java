package com.gabrielsantana.workshopmongo.repository;

import com.gabrielsantana.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
