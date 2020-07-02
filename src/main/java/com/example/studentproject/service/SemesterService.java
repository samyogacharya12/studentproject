package com.example.studentproject.service;

import com.example.studentproject.dto.SemesterDto;

import java.util.List;
import java.util.Map;

public interface SemesterService {

  SemesterDto save(SemesterDto semesterDto);

 List<SemesterDto> findAll();

  Map findAll(Integer pageNo, Integer pageSize, String sortBy);

 SemesterDto findById(Long id);



}
