package com.example.demo.request;

import java.util.UUID;

import com.example.demo.db.entity.StudentEntity;

import lombok.Getter;

@Getter
public class StudentRequest {
    

    private UUID courceId;

    private UUID semesterId;

    private String name;

    private String rollNo;

    private String gender;

    public boolean validate() {
        if (this.courceId == null || this.semesterId== null || this.name==null || this.gender==null || this.rollNo==null) {
            return false;
        }
        return true;
    }
    
    // convert to entity for transfer to repository;
    public StudentEntity convertToStudentEntity() {
        StudentEntity studentEntity = new StudentEntity(
            UUID.randomUUID(),
            this.courceId,
            this.semesterId,
            this.name,
            this.rollNo,
            this.gender
        );
        return studentEntity;
    }
    
}
