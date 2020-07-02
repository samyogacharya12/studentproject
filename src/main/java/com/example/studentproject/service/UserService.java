package com.example.studentproject.service;



import com.example.studentproject.dto.UserDto;
import com.example.studentproject.entity.User;

import java.util.List;

public interface UserService {


    User findUserByUserName(String userName);

    UserDto getUserByUsername(String username);

    UserDto findUserByUserId(Long id);

    User findByEmail(String email);

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    List<UserDto> findAll();

    UserDto findUserById(Long id);

    List<String> findAllUsername();


}
