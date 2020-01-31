package com.codeup.howellspringblog.repositories;

import com.codeup.howellspringblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
