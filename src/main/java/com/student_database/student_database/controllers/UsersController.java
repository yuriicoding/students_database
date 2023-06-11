package com.student_database.student_database.controllers;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student_database.student_database.models.User;
import com.student_database.student_database.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all users");
        //get all users from database 
        List<User> users = userRepo.findAll();
        //end of database call
        Collections.sort(users, Comparator.comparing(User::getUid));

        model.addAttribute("us", users);
        return "users/showAll";
    }

    @GetMapping("/users/show")
    public String presentUsers(Model model){
        System.out.println("Retrieving all users");
        //get all users from database 
        List<User> users = userRepo.findAll();
        //end of database call

        model.addAttribute("us", users);
        return "users/histogram";
    }

    @PostMapping("/users/add")
    public String addUser (@RequestParam Map<String, String> newuser, HttpServletResponse response){

        System.out.println("ADD user");
        String newName = newuser.get("name");
        Float newHeight = Float.parseFloat(newuser.get("height"));
        Float newWeight = Float.parseFloat(newuser.get("weight"));
        String newHair = newuser.get("hair_color");
        Float newGPA = Float.parseFloat(newuser.get("gpa"));
        userRepo.save(new User(newName, newHeight, newWeight, newHair, newGPA));
        response.setStatus(201);
        return "redirect:/users/view";
    }

    @GetMapping("/users/view/{uid}")
    public String changeUser (@RequestParam Map<String, String> newuser, HttpServletResponse response){

        int id = Integer.parseInt(newuser.get("uid"));
        String newName = newuser.get("name");
        Float newHeight = Float.parseFloat(newuser.get("height"));
        Float newWeight = Float.parseFloat(newuser.get("weight"));
        String newHair = newuser.get("hair_color");
        Float newGPA = Float.parseFloat(newuser.get("gpa"));

        System.out.println("CHANGE USER " + id);
        User u = userRepo.findById(id).get();
        System.out.println(u.getName());

        u.setGpa(newGPA);
        u.setHair_color(newHair);
        u.setHeight(newHeight);
        u.setWeight(newWeight);
        u.setName(newName);

        userRepo.save(u);
        return "redirect:/users/view";
    }

    @GetMapping("/users/delete")
    public String deleteUser (@RequestParam Map<String, String> newuser, HttpServletResponse response){

        System.out.println("DELETE user");
        int id = Integer.parseInt(newuser.get("uid"));
        User u = userRepo.findById(id).get();
        
        userRepo.delete(u);
        return "redirect:/users/view";
    }
}
