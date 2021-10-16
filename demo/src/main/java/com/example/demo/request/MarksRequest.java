package com.example.demo.request;

import java.util.UUID;

import com.example.demo.db.entity.MarksEntity;

import lombok.Getter;

@Getter
public class MarksRequest {
    

    private UUID courceId;

    private UUID semesterId;

    private UUID studentId;

    private UUID subjectId;

    private int marks;

    public boolean validate() {
        if (this.courceId == null || this.semesterId== null || this.studentId==null || this.subjectId==null) {
            return false;
        }
        return true;
    }
    
    // convert to entity for transfer to repository;
    public MarksEntity convertToStudentEntity() {
        MarksEntity marksEntity = new MarksEntity(
            UUID.randomUUID(),
            this.courceId,
            this.semesterId,
            this.studentId,
            this.subjectId,
            this.marks
        );
        return marksEntity;
    }
    
}
