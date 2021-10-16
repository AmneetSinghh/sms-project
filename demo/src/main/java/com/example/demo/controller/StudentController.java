package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import com.example.demo.Service.StudentService;
import com.example.demo.db.view.GenderRatioView;
import com.example.demo.db.view.MaximumStudentsCourceView;
import com.example.demo.db.view.SearchForStudentView;
import com.example.demo.request.StudentRequest;
import com.example.demo.util.GenericSmsResponse;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping(value = "/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    int addCource(@RequestBody StudentRequest studentRequest) throws Exception {
        if (studentRequest.validate() == false) {
            return -1;
        }
        int a;
        try {
            a = this.studentService.addStudent(studentRequest);
        } catch (Exception e) {
            System.out.print(e);
            return -1;
        }
        return a;
    }
    
    
    @GetMapping("/fetch-student")
    ResponseEntity<GenericSmsResponse> fetchStudent(
        @RequestParam(required = false) UUID id
    ) {
        try {
            SearchForStudentView searchForStudentView = this.studentService.fetch_student(id);    
            GenericSmsResponse genericSmsResponse = new GenericSmsResponse(
                "Successful",
                "student retrieved for the id: " + id,
                searchForStudentView
            );
            return new ResponseEntity<>(genericSmsResponse, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-maximum-students-cource")
    ResponseEntity<GenericSmsResponse> fetchMaximumStudentCource() {
        try {
            MaximumStudentsCourceView maximumStudentsCourceView = this.studentService.fetch_maximum_students_cource();    
            GenericSmsResponse genericSmsResponse = new GenericSmsResponse(
                "Successful",
                "Course wise students count",
                maximumStudentsCourceView
            );
            return new ResponseEntity<>(genericSmsResponse, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }
    

    //fetch_gender_ratio

    @GetMapping("/fetch-gender-ratio")
    ResponseEntity<GenericSmsResponse> fetchGenderRatio() {
        try {
            List<GenderRatioView> genderRatioViewList = this.studentService.fetch_gender_ratio();   
            
            GenericSmsResponse genericSmsResponse = new GenericSmsResponse(
                "Successful",
                "Gender ratio",
                genderRatioViewList
            );
            return new ResponseEntity<>(genericSmsResponse, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }
    







}
