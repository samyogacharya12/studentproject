package com.example.studentproject.controller;

import com.example.studentproject.dto.SemesterDto;
import com.example.studentproject.service.SemesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SemesterController {


    private SemesterService semesterService;

    private SemesterController(SemesterService semesterService)
    {
        this.semesterService=semesterService;
    }

    @PostMapping("/semester")
    public ResponseEntity<?> save(@RequestBody SemesterDto semesterDto)
    {
        semesterDto=semesterService.save(semesterDto);
        return new ResponseEntity<>(semesterDto, HttpStatus.OK);
    }

    @GetMapping("/semester")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy)
    {
        Map map=semesterService.findAll(pageNo-1, pageSize, sortBy);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/semester/findall")
    public ResponseEntity<?> getAll()
    {
        List<SemesterDto> semesterDtoList=semesterService.findAll();
        return new ResponseEntity<>(semesterDtoList, HttpStatus.OK);
    }


    @GetMapping("/semester/{id}")
   public ResponseEntity<?> findById(@PathVariable Long id)
   {
       SemesterDto semesterDto=semesterService.findById(id);
       return new ResponseEntity<>(semesterDto, HttpStatus.OK);
   }



}
