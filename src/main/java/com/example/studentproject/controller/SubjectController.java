package com.example.studentproject.controller;

import com.example.studentproject.dto.SubjectDto;
import com.example.studentproject.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SubjectController {


    private SubjectService subjectService;

    private SubjectController(SubjectService subjectService)
    {
        this.subjectService=subjectService;
    }

    @PostMapping("/subject")
    public ResponseEntity<?> save(@RequestBody SubjectDto subjectDto)
    {
        subjectDto=subjectService.save(subjectDto);
        return new ResponseEntity<>(subjectDto, HttpStatus.OK);
    }


    @GetMapping("/subject/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        SubjectDto subjectDto=subjectService.findById(id);
        return new ResponseEntity<>(subjectDto, HttpStatus.OK);
    }


    @GetMapping("/subject")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy)
    {
        Map map=subjectService.findAll(pageNo-1, pageSize, sortBy);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/subject/getall")
    public ResponseEntity<?> getAll()
    {
        List<SubjectDto> subjectDtoList=subjectService.findAll();
        return new ResponseEntity<>(subjectDtoList, HttpStatus.OK);
    }

}
