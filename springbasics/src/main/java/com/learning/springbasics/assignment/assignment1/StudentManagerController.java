package com.learning.springbasics.assignment.assignment1;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentManagerController {

    List<Student> studentList = new ArrayList<>();

    // Create a new student with int rollNo, String name, boolean isPresent, Date dateOfBirth
    // rollNo should be greater than 0 and unique, name should be present, dateOfBirth must be path
    // -> POST /students/ {with body}
    @PostMapping("/")
    Student createStudent(@RequestBody Student student){
        Date todayDate = new Date();
        if(student.getRollNo() == null || student.getRollNo() < 0 || notUniqueRollNo(student.getRollNo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "rollNo must uniquely exists and greater than 0 ");
        }
        if(student.getName() == null || student.getName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name cannot be null or empty");
        }
        if(student.getDateOfBirth() == null || student.getDateOfBirth().after(todayDate)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid dateOfBirth: must be in the past");
        }
        studentList.add(student);
        return student;
    }

    boolean notUniqueRollNo(Integer rollNo){
        for(Student st : studentList){
            if(st.getRollNo().equals(rollNo))
                    return true;
        }
        return false;
    }

    // Get all students
    // -> GET /students/
    @GetMapping("/")
    List<Student> getAllStudents(){
        return studentList;
    }

    // Get student by roll number
    // -> GET /students/{rollNo}
    @GetMapping("/{rollNo}")
    Student getStudentByRollNo(@PathVariable("rollNo") Integer rollNo) {
        Student student = null;
        for(Student st : studentList){
            if(st.getRollNo()==rollNo) {
                student = st;
                break;
            }
        }
        if(student == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with roll number " + rollNo + " Not Exist.");
        return student;
    }

    //Update a student (isPresent(true/false) and dateOfBirth(yyyy-MM-dd)) can be updated if exist(rollNo)
    // -> PATCH /students/{rollNo}/{DOB}/{isPresent}
    @PatchMapping("/{rollNo}/{DOB}/{isPresent}")
    Student updateStudent(@PathVariable("rollNo") Integer rollNo, @PathVariable("DOB") @DateTimeFormat(pattern = "yyyy-MM-dd") Date DOB,@PathVariable("isPresent") Boolean isPresent){
        for(Student st : studentList){
            if(st.getRollNo().equals(rollNo)){
                st.setDateOfBirth(DOB);
                st.setPresent(isPresent);
                return st;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with roll number " + rollNo + " Not Exist.");
    }

    @PatchMapping("/{rollNo}")
    Student updateStudent(@PathVariable("rollNo") Integer rollNo,@RequestBody Student student){
        String name = student.getName();
        Date dob = student.getDateOfBirth();
        boolean isPresent  = student.isPresent();

        for(Student st : studentList){
            if(st.getRollNo().equals(rollNo)){
                st.setName(name);
                st.setDateOfBirth(dob);
                st.setPresent(isPresent);
                return st;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with roll number " + rollNo + " Not Exist.");
    }

    //Delete a student
    // -> DELETE /students/{rollNo}
    @DeleteMapping("/{rollNo}")
    String deleteStudent(@PathVariable("rollNo") Integer rollNo){
        for(Student st : studentList){
            if(st.getRollNo().equals(rollNo)){
                studentList.remove(st);
                return "Deleted Successfully !!!";
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with roll number " + rollNo + " Not Exist.");
    }

}
