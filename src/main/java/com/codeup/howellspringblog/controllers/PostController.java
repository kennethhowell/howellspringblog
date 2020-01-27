package com.codeup.howellspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody

    public String postsPage(){
        return "Index page for posts!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsID(@PathVariable String id){
        return "View an invidual post will go here!";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Will hold the area to create a new post and listen for the forms POST request!";
    }
//    @PostMapping("/posts/create")
}
