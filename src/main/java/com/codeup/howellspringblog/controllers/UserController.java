package com.codeup.howellspringblog.controllers;


import com.codeup.howellspringblog.model.User;
import com.codeup.howellspringblog.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UsersRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UsersRepository users, PasswordEncoder passwordEncoder){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "posts/register";

    }

    @PostMapping("/sign-up")
    public String addUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

}
