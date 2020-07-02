package com.example.studentproject.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SemesterDto implements Serializable {


    private Long id;

    private String created;

    private String lastModified;

    private Integer version;

    private String sectionName;


    private String semesterName;

    private List<StudentDetailDto> studentDetailDtoList=new ArrayList<>();


    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public List<StudentDetailDto> getStudentDetailDtoList() {
        return studentDetailDtoList;
    }

    public void setStudentDetailDtoList(List<StudentDetailDto> studentDetailDtoList) {
        this.studentDetailDtoList = studentDetailDtoList;
    }
}
