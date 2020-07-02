package com.example.studentproject.entity;

import com.example.studentproject.abstractclasses.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="subject")
public class Subject extends AbstractEntity {


    @Column(name="subject_name", unique = true)
    @NotNull(message = "subject name cannot ne null")
    private String subjectName;

    @Column(name="subject_code", unique = true)
    private String subjectCode;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
