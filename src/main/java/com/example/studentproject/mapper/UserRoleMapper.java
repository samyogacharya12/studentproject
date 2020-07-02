package com.example.studentproject.mapper;

import com.example.studentproject.dto.UserRoleDto;
import com.example.studentproject.entity.security.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface UserRoleMapper extends EntityMapper<UserRoleDto, UserRole> {

    @Mapping(source = "userDto", target = "user")
    @Mapping(source = "roleDto", target = "role")
    UserRole toEntity(UserRoleDto userRoleDto);

    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "role", target = "roleDto")
    UserRoleDto toDto(UserRole userRole);
}
