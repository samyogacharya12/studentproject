package com.example.studentproject.service;

import com.example.studentproject.dto.UserDto;
import com.example.studentproject.dto.UserRoleDto;
import com.example.studentproject.entity.User;
import com.example.studentproject.entity.security.UserRole;
import com.example.studentproject.mapper.RoleMapper;
import com.example.studentproject.mapper.UserRoleMapper;
import com.example.studentproject.repository.UserRepository;
import com.example.studentproject.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserRoleDto> findUserRoleByUser(UserDto userDto) {
        User user = userRepository.findUserByUsername(userDto.getUsername());
        List<UserRole> userRoleList = userRoleRepository.findByUser(user);
        List<UserRoleDto> userRoleDto = new ArrayList<>();
        UserRoleDto userRoleDto1 = new UserRoleDto();
        for (UserRole userRole : userRoleList) {
            userRoleDto1.setRoleDto(roleMapper.toDto(userRole.getRole()));
        }
        userRoleDto.add(userRoleDto1);
        return userRoleDto;
    }

    @Override
    public UserRoleDto save(UserRoleDto userRoleDto) {
        UserRole userRole = userRoleMapper.toEntity(userRoleDto);
        return userRoleMapper.toDto(userRoleRepository.save(userRole));
    }
}
