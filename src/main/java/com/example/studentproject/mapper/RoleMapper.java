package com.example.studentproject.mapper;

import com.example.studentproject.dto.RoleDto;
import com.example.studentproject.entity.security.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, Role> {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);
}
