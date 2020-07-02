package com.example.studentproject.entity;

import com.example.studentproject.abstractclasses.AbstractEntity;
import com.example.studentproject.enumconstant.ResultStatus;

import javax.persistence.*;

@Entity
@Table(name="marksheet")
public class Marksheet extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;


    @ManyToOne
    @JoinColumn(name="student_id")
    private StudentDetail studentDetail;

    @Column(name="full_marks")
    private int fullMarks;

    @Column(name = "pass_marks")
    private int passMarks;

    @Column(name="obtained_marks")
    private int obtainedMarks;

    @Column(name="result_status")
    private ResultStatus resultStatus;


    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public int getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(int fullMarks) {
        this.fullMarks = fullMarks;
    }

    public int getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(int passMarks) {
        this.passMarks = passMarks;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }
}
