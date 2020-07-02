package com.example.studentproject.dto;

import java.io.Serializable;

public class UserRoleDto implements Serializable {

    private UserDto userDto;

    private RoleDto roleDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public RoleDto getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(RoleDto roleDto) {
        this.roleDto = roleDto;
    }
}
