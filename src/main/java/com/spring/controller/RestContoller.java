package com.spring.controller;

import com.spring.entities.Position;
import com.spring.entities.Post;
import com.spring.entities.User;
import com.spring.repository.PositionRepository;
import com.spring.repository.PostRepository;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestContoller {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PositionRepository positionRepository;

    @PostMapping("/create")
    public User create(@RequestBody User user){

//        validate
       List<User> userList = userRepository.findByLoginNameOrEmail(user.getLoginName(), user.getEmail());
       if(userList.size() >0){
         return  null;
       }

        userRepository.save(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUser(){
        List<User> userList = userRepository.findAll();

        return  userList;
    }

    @GetMapping("/search-users")
    public List<User> searchUsers(@RequestParam("id") Integer id){
        return  userRepository.findUserByPost(id);
    }

    @GetMapping("/departments")
    public List<Post> departmentList(){
        return postRepository.findAll();
    }

    @GetMapping("/positions")
    public List<Position> positionList(){
        return positionRepository.findAll();
    }
}
