package com.example.studentproject.service;

import com.example.studentproject.dto.StudentDetailDto;

import java.util.List;
import java.util.Map;

public interface StudentDetailService {


    StudentDetailDto save(StudentDetailDto studentDetailDto);

    Map findAll(Integer pageNo, Integer pageSize, String sortBy);

    List<StudentDetailDto> findAll();

    StudentDetailDto findById(Long id);



}
