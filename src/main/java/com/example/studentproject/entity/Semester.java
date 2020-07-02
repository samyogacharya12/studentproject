package com.example.studentproject.entity;

import com.example.studentproject.abstractclasses.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="semister")
public class Semester extends AbstractEntity {


  @Column(name="semester_name", nullable = false)
  private String semesterName;


  @Column(name="section_name", nullable = false, unique = true)
  private String sectionName;


  @OneToMany(mappedBy = "semester")
  private List<StudentDetail> studentDetails=new ArrayList<>();


    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<StudentDetail> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<StudentDetail> studentDetails) {
        this.studentDetails = studentDetails;
    }
}
