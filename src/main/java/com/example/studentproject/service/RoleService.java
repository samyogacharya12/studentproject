package com.example.studentproject.service;

import com.example.studentproject.dto.RoleDto;
import com.example.studentproject.enumconstant.Status;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAllRoles(Status status);

    RoleDto getRoleByName(String role);
}
