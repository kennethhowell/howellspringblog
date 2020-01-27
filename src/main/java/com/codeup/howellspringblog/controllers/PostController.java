package com.codeup.howellspringblog.controllers;

import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsPage(){

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsID(@PathVariable String id, Model model){
        Post testsinglePost = new Post("Test title", "Your body is a wonderland!");


        model.addAttribute("post", testsinglePost);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Will hold the area to create a new post and listen for the forms POST request!";
    }
//    @PostMapping("/posts/create")
}
