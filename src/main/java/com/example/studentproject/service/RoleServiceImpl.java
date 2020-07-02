package com.example.studentproject.service;

import com.example.studentproject.dto.RoleDto;
import com.example.studentproject.enumconstant.Status;
import com.example.studentproject.mapper.RoleMapper;
import com.example.studentproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDto> findAllRoles(Status status) {
        return roleMapper.toDto(roleRepository.findAllByStatus(status));
    }

    @Override
    public RoleDto getRoleByName(String role) {
        return roleMapper.toDto(roleRepository.findByName(role));
    }

}
