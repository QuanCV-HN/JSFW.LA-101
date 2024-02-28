package com.spring.controller;

import com.spring.entities.User;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public String userPage(){
        return "user";
    }

    @GetMapping(value = {"/home","/","/index"})
    public String homePage(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

//    @PostMapping("/create")
//    public String addUser(@ModelAttribute("user") User user,Model model){
//        //validate
//       List<User> userList = userRepository.findByLoginNameOrEmail(user.getLoginName(), user.getEmail());
//       if(userList.size() >0){
//           model.addAttribute("message", "User đã tồn tại");
//           return "index";
//       }
//
//       userRepository.save(user);
//        return "redirect:/index";
//    }
}
