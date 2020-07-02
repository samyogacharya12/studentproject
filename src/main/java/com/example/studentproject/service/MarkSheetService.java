package com.example.studentproject.service;

import com.example.studentproject.dto.MarkSheetDto;

import java.util.Map;

public interface MarkSheetService {

    MarkSheetDto save(MarkSheetDto markSheetDto);

    Map findAll(Integer pageNo, Integer pageSize, String sortBy);

    MarkSheetDto findById(Long id);

}
