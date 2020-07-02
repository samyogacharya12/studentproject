package com.example.studentproject.mapper;

import com.example.studentproject.dto.MarkSheetDto;
import com.example.studentproject.entity.Marksheet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface MarksheetMapper extends EntityMapper<MarkSheetDto, Marksheet> {

    @Mapping(source = "subject.id", target = "subjectId")
    @Mapping(source = "subject.subjectName", target = "subjectName")
    @Mapping(source = "studentDetail.id", target = "studentId")
    @Mapping(source = "studentDetail.firstName", target = "firstName")
    @Mapping(source = "studentDetail.middleName", target = "middleName")
    @Mapping(source = "studentDetail.lastName", target = "lastName")
    MarkSheetDto toDto(Marksheet marksheet);

    @Mapping(source = "subjectId", target = "subject.id")
    @Mapping(source = "studentId", target = "studentDetail.id")
    Marksheet toEntity(MarkSheetDto markSheetDto);

}
