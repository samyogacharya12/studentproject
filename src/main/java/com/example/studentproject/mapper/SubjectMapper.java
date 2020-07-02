package com.example.studentproject.mapper;

import com.example.studentproject.dto.SubjectDto;
import com.example.studentproject.entity.Subject;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface SubjectMapper extends EntityMapper<SubjectDto, Subject> {


    SubjectDto toDto(Subject subject);


    Subject toEntity(SubjectDto subjectDto);

}
