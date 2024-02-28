package com.spring.repository;

import com.spring.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findByNamePost (String namePost);
}
