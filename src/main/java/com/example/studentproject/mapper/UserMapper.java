package com.example.studentproject.mapper;

import com.example.studentproject.dto.UserDto;
import com.example.studentproject.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {

    UserDto toDto(User user);


    User toEntity(UserDto userDto);
}
