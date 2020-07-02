package com.example.studentproject.service;


import com.example.studentproject.dto.UserDto;
import com.example.studentproject.entity.User;
import com.example.studentproject.mapper.UserMapper;
import com.example.studentproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        UserDto userDto = userMapper.toDto(userRepository.findUserByUsername(username));
        return userDto;
    }

    @Override
    public UserDto findUserByUserId(Long id) {
        User user = userRepository.findUserById(id);
        return userMapper.toDto(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user=userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findUserById(id);
        return userMapper.toDto(user);
    }

    @Override
    public List<String> findAllUsername() {
        return userRepository.getUserNameList();
    }


}
