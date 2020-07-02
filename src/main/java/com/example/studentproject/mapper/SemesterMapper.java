package com.example.studentproject.mapper;

import com.example.studentproject.dto.SemesterDto;
import com.example.studentproject.entity.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = {StudentDetailMapper.class})
public interface SemesterMapper extends EntityMapper<SemesterDto, Semester> {


    @Mapping(source = "studentDetails", target = "studentDetailDtoList")
    SemesterDto toDto(Semester semester);


    @Mapping(source = "studentDetailDtoList", target = "studentDetails")
    Semester toEntity(SemesterDto semesterDto);



}
