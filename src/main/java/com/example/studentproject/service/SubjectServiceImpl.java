package com.example.studentproject.service;

import com.example.studentproject.dto.SubjectDto;
import com.example.studentproject.entity.Subject;
import com.example.studentproject.mapper.SubjectMapper;
import com.example.studentproject.repository.SubjectRepository;
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
public class SubjectServiceImpl implements SubjectService {


    @Autowired
    private SubjectRepository subjectRepository;


    @Autowired
    private SubjectMapper subjectMapper;

    private SubjectServiceImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper){
        this.subjectRepository=subjectRepository;
        this.subjectMapper=subjectMapper;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject=subjectMapper.toEntity(subjectDto);
        return subjectMapper.toDto(subjectRepository.save(subject));
    }

    @Override
    public Map findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Map<String, Object> map=new HashMap<>();
        Page<SubjectDto> subjectDtos=subjectRepository.findAll(pageable).map(subjectMapper::toDto);
        map.put("details", subjectDtos.getContent());
        map.put("totalPages", subjectDtos.getTotalElements());
        if(subjectDtos.hasContent())
        {
            return map;
        }
        else{
            return new HashMap();
        }
    }

    @Override
    public List<SubjectDto> findAll() {
        return subjectMapper.toDto(subjectRepository.findAll());
    }

    @Override
    public SubjectDto findById(Long id) {
        return subjectMapper.toDto(subjectRepository.getOne(id));
    }
}
