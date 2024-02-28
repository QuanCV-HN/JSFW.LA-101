package com.spring.repository;

import com.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

//    @Query(value = "select u from User u JOIN u.post p on u.postId = p.id where p.namePost = ?1")
//    List<User> findByDepartment (String department );

    List<User> findByLoginNameOrEmail(String loginName, String email);


    @Query(value = "select u from User  u where u.post.id = ?1")
    List<User> findUserByPost(Integer id);

}
