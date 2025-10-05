package com.example.todolist.controller;

import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-detail";
        } else {
            return "error";
        }
    }
}
