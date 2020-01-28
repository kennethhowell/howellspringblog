package com.codeup.howellspringblog.controllers;

import model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsPage(Model model){
        ArrayList<Post> demoMultiplePosts = new ArrayList<>();

        Post testpost1 = new Post("I love fish", "That's why for capstone I'm doing an urban fishing project!");
        Post testpost2 = new Post("Looking at my urban fishing project", "Using a raspberry pi, I'm going to build a robotic fish!");
        demoMultiplePosts.add(testpost1);
        demoMultiplePosts.add(testpost2);

        model.addAttribute("demoMultiplePosts", demoMultiplePosts);
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
