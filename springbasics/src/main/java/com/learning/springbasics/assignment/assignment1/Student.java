package com.learning.springbasics.assignment.assignment1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student {
    Integer rollNo;
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    Date dateOfBirth;
    boolean isPresent;

    public Student(Integer rollNo, String name, boolean isPresent, Date dateOfBirth) {
        this.rollNo = rollNo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.isPresent = isPresent;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public Student setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public Student setPresent(boolean isPresent) {
        this.isPresent = isPresent;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Student setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
