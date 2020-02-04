package com.codeup.howellspringblog.controllers;

import com.codeup.howellspringblog.model.*;

import com.codeup.howellspringblog.repositories.PostDetailsRepository;
import com.codeup.howellspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.howellspringblog.repositories.PostRepository;
import com.codeup.howellspringblog.repositories.UserRepository;


@Controller
public class PostController {


    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;
    private final PostDetailsRepository PostDetailsDao;



    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService, PostDetailsRepository PostDetailsDao){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
        this.PostDetailsDao = PostDetailsDao;
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

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String postEdit(@RequestParam(name = "id") long id, @RequestParam(name = "title") String title, @RequestParam(name="body") String body, Model model){
        Post updatePost = new Post (id, title, body);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        updatePost.setUser(userDao.getOne(user.getId()));
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

    @GetMapping("/posts/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("postDetails", new PostDetails());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, @ModelAttribute PostDetails postDetails){
        postDetails.setPost(post);
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postDao.save(post);
        PostDetailsDao.save(postDetails);
        emailService.prepareAndSend(post,"New post written", "Good job, keep writing!");
       return "redirect:/posts";


    }
}
