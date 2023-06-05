package com.adith.springjpa.controller;

import com.adith.springjpa.entities.User;
import com.adith.springjpa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/admin")
public class UserController {

    User user;
    UserRepo userRepo;
    UserController(User user,UserRepo userRepo){
        this.user=user;
        this.userRepo=userRepo;
    }


    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String city,@RequestParam String status){
        user.setName(name);
        user.setCity(city);
        user.setStatus(status);


        userRepo.save(user);
        System.out.println(user);

        return "details added successfully";
    }

}
