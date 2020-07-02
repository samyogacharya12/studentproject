package com.example.studentproject.mapper;

import com.example.studentproject.dto.StudentDetailDto;
import com.example.studentproject.entity.StudentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface StudentDetailMapper extends EntityMapper<StudentDetailDto, StudentDetail> {


    @Mapping(source = "semester", target = "semesterDto")
    StudentDetailDto toDto(StudentDetail studentDetail);

    @Mapping(source = "semesterId", target = "semester.id")
    StudentDetail toEntity(StudentDetailDto studentDetailDto);



}
