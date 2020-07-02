package com.example.studentproject.controller;

import com.example.studentproject.dto.StudentDetailDto;
import com.example.studentproject.service.StudentDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentDetailController  {

    private StudentDetailService studentDetailService;

    private StudentDetailController(StudentDetailService studentDetailService)
    {
        this.studentDetailService=studentDetailService;
    }

    @PostMapping("/studentdetail")
    public ResponseEntity<?> save(@RequestBody StudentDetailDto studentDetailDto)
    {
        studentDetailDto=studentDetailService.save(studentDetailDto);
        return new ResponseEntity<>(studentDetailDto, HttpStatus.OK);
    }

    @GetMapping("/studentdetail/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        StudentDetailDto studentDetailDto=studentDetailService.findById(id);
        return new ResponseEntity<>(studentDetailDto, HttpStatus.OK);
    }


    @GetMapping("/studentdetail/findall")
    public ResponseEntity<?> getAll()
    {
        List<StudentDetailDto> studentDetailDtoList=studentDetailService.findAll();
        return new ResponseEntity<>(studentDetailDtoList, HttpStatus.OK);
    }


    @GetMapping("/studentdetail")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy)
    {
        Map map=studentDetailService.findAll(pageNo-1, pageSize, sortBy);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }



}
