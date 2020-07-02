package com.example.studentproject.service;

import com.example.studentproject.dto.SemesterDto;
import com.example.studentproject.entity.Semester;
import com.example.studentproject.mapper.SemesterMapper;
import com.example.studentproject.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SemesterServiceimpl implements SemesterService {


    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private SemesterMapper semesterMapper;

    private SemesterServiceimpl(SemesterRepository semesterRepository, SemesterMapper semesterMapper)
    {
        this.semesterRepository=semesterRepository;
        this.semesterMapper=semesterMapper;
    }

    @Override
    public SemesterDto save(SemesterDto semesterDto) {
        Semester semester=semesterMapper.toEntity(semesterDto);
        return semesterMapper.toDto(semesterRepository.save(semester));
    }

    @Override
    public List<SemesterDto> findAll() {
        return semesterMapper.toDto(semesterRepository.findAll());
    }

    @Override
    public Map findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Map<String, Object> map=new HashMap<>();
        Page<SemesterDto> semesterDtoPage=semesterRepository.findAll(pageable).map(semesterMapper::toDto);
        map.put("details", semesterDtoPage.getContent());
        map.put("totalPage", semesterDtoPage.getTotalElements());
        if (semesterDtoPage.hasContent())
        {
            return map;
        }
        else{
            return new HashMap();
        }
    }

    @Override
    public SemesterDto findById(Long id) {
        return semesterMapper.toDto(semesterRepository.getOne(id));
    }


}
