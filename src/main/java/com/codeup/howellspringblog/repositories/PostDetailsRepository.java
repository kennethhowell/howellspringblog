package com.codeup.howellspringblog.repositories;

import com.codeup.howellspringblog.model.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
