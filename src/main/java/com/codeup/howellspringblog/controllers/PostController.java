package com.codeup.howellspringblog.controllers;

import com.codeup.howellspringblog.model.*;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String postsPage(Model model){


        model.addAttribute("demoMultiplePosts", postDao.findAll());
        return "posts/index";
    }

    @PostMapping("/posts/{id}")
    public String postsID(@PathVariable long id, Model model){

        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Will hold the area to create a new post and listen for the forms POST request!";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String postEdit(@RequestParam(name = "id") long id, @RequestParam(name = "title") String title, @RequestParam(name="body") String body, Model model){
        Post updatePost = new Post (id, title, body);
        postDao.save(updatePost);
        model.addAttribute("post", postDao.getOne(id));
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String postDelete(@RequestParam(name = "id") String id, Model model){
        long postID = Long.parseLong(id);
        postDao.deleteById(postID);
        return "redirect:/posts";
    }


//    @PostMapping("/posts/create")
}
