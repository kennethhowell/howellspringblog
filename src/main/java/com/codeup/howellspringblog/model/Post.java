package com.codeup.howellspringblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;


    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false, length = 800)
    private String body;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "post")
    private PostDetails postdetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> postImageList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(){};



    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PostDetails getPostdetails() {
        return postdetails;
    }

    public void setPostdetails(PostDetails postdetails) {
        this.postdetails = postdetails;
    }

    public List<PostImage> getPostImageList() {
        return postImageList;
    }

    public void setPostImageList(List<PostImage> postImageList) {
        this.postImageList = postImageList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

