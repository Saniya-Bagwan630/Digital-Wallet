package com.pict.controller;

import com.pict.studentapi.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "Student Management REST API";
    }

    // CREATE
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student Added Successfully";
    }

    // READ ALL
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    // READ BY ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // UPDATE
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id,
                                @RequestBody Student updatedStudent) {

        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setBranch(updatedStudent.getBranch());
                return "Student Updated Successfully";
            }
        }
        return "Student Not Found";
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                return "Student Deleted Successfully";
            }
        }
        return "Student Not Found";
    }
}