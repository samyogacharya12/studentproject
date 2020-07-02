package com.example.studentproject.controller;

import com.example.studentproject.dto.MarkSheetDto;
import com.example.studentproject.service.MarkSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MarksheetController {


    @Autowired
    private MarkSheetService markSheetService;

    private MarksheetController(MarkSheetService markSheetService)
    {
        this.markSheetService=markSheetService;
    }


    @PostMapping("/marksheet")
    public ResponseEntity<?> save(@RequestBody MarkSheetDto markSheetDto)
    {
        markSheetDto=markSheetService.save(markSheetDto);
        return new ResponseEntity<>(markSheetDto, HttpStatus.OK);
    }

    @GetMapping("/marksheet")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "id") String sortBy)
    {
        Map map=markSheetService.findAll(pageNo-1, pageSize, sortBy);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/marksheet/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        MarkSheetDto markSheetDto=markSheetService.findById(id);
        return new ResponseEntity<>(markSheetDto, HttpStatus.OK);
    }



}
