package com.example.studentproject.entity;

import com.example.studentproject.abstractclasses.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Table(name="student_detail")
public class StudentDetail extends AbstractEntity {


   @Column(name="first_name", nullable = false)
   private String firstName;

   @Column(name="middle_name")
   private String middleName;

   @Column(name="last_name", nullable = false)
   private String lastName;

   @Column(name="email", unique = true)
   @Email(message = "Email should be valid")
   private String email;

   @Column(name="mobile_number")
   private String mobileNumber;


   @Column(name="date_of_birth", nullable = false)
   private LocalDateTime dateOfBirth;

   @Column(name="joined_date", nullable = false)
   private LocalDateTime joinedDate;


   @Column(name="temporary_address", nullable = false)
   private String temporaryAddress;

   @Column(name="permanent_address", nullable = false)
   private String permanentAddress;

   @Column(name="gardian_name", nullable = false)
   private String guardianName;


   @Column(name="gardian_phone_number", nullable = false)
   private String guardianPhoneNumber;

   @Column(name="previous_degree", nullable = false)
   private String previousDegree;

   @Column(name="previous_school", nullable = false)
   private String previousSchool;

   @ManyToOne
   @JoinColumn(name="semister_id", nullable = false)
   private Semester semester;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianPhoneNumber() {
        return guardianPhoneNumber;
    }

    public void setGuardianPhoneNumber(String guardianPhoneNumber) {
        this.guardianPhoneNumber = guardianPhoneNumber;
    }

    public String getPreviousDegree() {
        return previousDegree;
    }

    public void setPreviousDegree(String previousDegree) {
        this.previousDegree = previousDegree;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
