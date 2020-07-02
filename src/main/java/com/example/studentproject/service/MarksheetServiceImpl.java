package com.example.studentproject.service;

import com.example.studentproject.dto.MarkSheetDto;
import com.example.studentproject.entity.Marksheet;
import com.example.studentproject.enumconstant.ResultStatus;
import com.example.studentproject.mapper.MarksheetMapper;
import com.example.studentproject.repository.MarkSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MarksheetServiceImpl implements MarkSheetService {

    @Autowired
    private MarkSheetRepository markSheetRepository;

    @Autowired
    private MarksheetMapper marksheetMapper;

    private MarksheetServiceImpl(MarksheetMapper marksheetMapper, MarkSheetRepository markSheetRepository)
    {
        this.marksheetMapper=marksheetMapper;
        this.markSheetRepository=markSheetRepository;
    }


    @Override
    public MarkSheetDto save(MarkSheetDto markSheetDto) {
        Marksheet marksheet=marksheetMapper.toEntity(markSheetDto);
        if(marksheet.getObtainedMarks()<40)
        {
          marksheet.setResultStatus(ResultStatus.Fail);
        }
        else{
            marksheet.setResultStatus(ResultStatus.PASS);
        }
        return marksheetMapper.toDto(markSheetRepository.save(marksheet));
    }

    @Override
    public Map findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Map<String, Object> map=new HashMap<>();
        Pageable pageable= PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<MarkSheetDto> markSheetDtos=markSheetRepository.findAll(pageable).map(marksheetMapper::toDto);
        map.put("details", markSheetDtos.getContent());
        map.put("totalPage", markSheetDtos.getTotalElements());
        if(markSheetDtos.hasContent())
        {
            return map;
        }
        else{
            return new HashMap();
        }
    }

    @Override
    public MarkSheetDto findById(Long id) {
        return marksheetMapper.toDto(markSheetRepository.getOne(id));
    }
}
