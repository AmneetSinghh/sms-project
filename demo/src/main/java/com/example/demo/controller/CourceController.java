package com.example.demo.controller;

import com.example.demo.Service.CourceService;
import com.example.demo.request.CourceRequest;
import com.example.demo.request.SemesterRequest;
import com.example.demo.request.SubjectRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cource")
public class CourceController {


    @Autowired
    private CourceService courceService;

    @PostMapping("/add")
    int addCource(@RequestBody CourceRequest courceRequest) throws Exception {
        if (courceRequest.validate() == false) {
            return -1;
        }
        int a;
        try {
            a = this.courceService.addCource(courceRequest);
        } catch (Exception e) {
            System.out.print(e);
            return -1;
        }
        return a;
    }


    @PostMapping("/add/semester")
    int addSemester(@RequestBody SemesterRequest semesterRequest) throws Exception {
        if (semesterRequest.validate() == false) {
            return -1;
        }
        int a;
        try {
            a = this.courceService.addSemester(semesterRequest);
        } catch (Exception e) {
            System.out.print(e);
            return -1;
        }
        return a;
    }

    @PostMapping("/add/semester/subject")
    int addSemester(@RequestBody SubjectRequest subjectRequest) throws Exception {
        if (subjectRequest.validate() == false) {
            return -1;
        }
        int a;
        try {
            a = this.courceService.addSubject(subjectRequest);
        } catch (Exception e) {
            System.out.print(e);
            return -1;
        }
        return a;
    }
    
}