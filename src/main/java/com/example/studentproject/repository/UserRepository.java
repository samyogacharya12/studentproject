package com.example.studentproject.repository;

import com.example.studentproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByUsername(String username);

    @Query("select u.username from  User u ")
    List<String> getUserNameList();

    User findByEmail(String email);



}
