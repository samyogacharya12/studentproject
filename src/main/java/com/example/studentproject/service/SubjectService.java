package com.example.studentproject.service;

import com.example.studentproject.dto.SubjectDto;

import java.util.List;
import java.util.Map;

public interface SubjectService {

    SubjectDto save(SubjectDto subjectDto);

    Map findAll(Integer pageNo, Integer pageSize, String sortBy);

    List<SubjectDto> findAll();

    SubjectDto findById(Long id);

}
