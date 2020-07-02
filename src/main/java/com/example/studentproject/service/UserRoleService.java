package com.example.studentproject.service;

import com.example.studentproject.dto.UserDto;
import com.example.studentproject.dto.UserRoleDto;

import java.util.List;

public interface UserRoleService {

    List<UserRoleDto> findUserRoleByUser(UserDto userDto);

    UserRoleDto save(UserRoleDto userRoleDto);
}
