package com.example.studentproject.service;

import com.example.studentproject.dto.StudentDetailDto;
import com.example.studentproject.entity.StudentDetail;
import com.example.studentproject.mapper.SemesterMapper;
import com.example.studentproject.mapper.StudentDetailMapper;
import com.example.studentproject.repository.StudentDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    private final Logger log = LoggerFactory.getLogger(StudentDetailServiceImpl.class);


    @Autowired
    private StudentDetailRepository studentDetailRepository;

    @Autowired
    private SemesterMapper semesterMapper;

    @Autowired
    private StudentDetailMapper studentDetailMapper;


    private StudentDetailServiceImpl(StudentDetailRepository studentDetailRepository, StudentDetailMapper studentDetailMapper)
    {
        this.studentDetailMapper=studentDetailMapper;
        this.studentDetailRepository=studentDetailRepository;
    }


    @Override
    public StudentDetailDto save(StudentDetailDto studentDetailDto) {
        log.debug("Request to Save  Student Detail");
        StudentDetail studentDetail=studentDetailMapper.toEntity(studentDetailDto);
        return studentDetailMapper.toDto(studentDetailRepository.save(studentDetail));
    }

    @Override
    public Map findAll(Integer pageNo, Integer pageSize, String sortBy) {
        log.debug("Request to get all Student Detail");
        Map<String, Object> map=new HashMap<>();
        Pageable pageable= PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<StudentDetailDto> studentDetailDtoPage=studentDetailRepository.findAll(pageable).map(list->convertToDto(list));
        map.put("details", studentDetailDtoPage.getContent());
        map.put("totalPage", studentDetailDtoPage.getTotalElements());
        if(studentDetailDtoPage.hasContent())
        {
            return map;
        }
        else{
            return new HashMap();
        }
    }

    @Override
    public List<StudentDetailDto> findAll() {
        return studentDetailMapper.toDto(studentDetailRepository.findAll());
    }

    @Override
    public StudentDetailDto findById(Long id) {
        return studentDetailMapper.toDto(studentDetailRepository.getOne(id));
    }

    private StudentDetailDto convertToDto(StudentDetail studentDetail)
    {
        StudentDetailDto studentDetailDto=new StudentDetailDto();
        studentDetailDto.setId(studentDetail.getId());
        ZoneId toZone = ZoneId.of("Asia/Kathmandu");
        studentDetailDto.setFirstName(studentDetail.getFirstName());
        studentDetailDto.setMiddleName(studentDetail.getMiddleName());
        studentDetailDto.setLastName(studentDetail.getLastName());
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")
                        .withZone(toZone);

        studentDetailDto.setSemesterDto(semesterMapper.toDto(studentDetail.getSemester()));
        studentDetailDto.setCreated(studentDetail.getCreated().toString());
        studentDetailDto.setDateOfBirth(formatter.format(studentDetail.getDateOfBirth()));
        studentDetailDto.setJoinedDate(formatter.format(studentDetail.getJoinedDate()));
        studentDetailDto.setEmail(studentDetail.getEmail());
        studentDetailDto.setPreviousSchool(studentDetail.getPreviousSchool());
        studentDetailDto.setPreviousDegree(studentDetail.getPreviousDegree());
        return studentDetailDto;
    }



}
