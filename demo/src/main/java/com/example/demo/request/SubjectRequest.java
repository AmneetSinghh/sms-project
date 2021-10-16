package com.example.demo.request;

import java.util.UUID;

import com.example.demo.db.entity.SubjectEntity;

import lombok.Getter;

@Getter
public class SubjectRequest {
    

    private UUID courceId;

    private UUID semesterId;

    private String subjectName;

    public boolean validate() {
        if (this.courceId == null || this.semesterId== null || this.subjectName==null) {
            return false;
        }
        return true;
    }
    
    // convert to entity for transfer to repository;
    public SubjectEntity convertToSubjectEntity() {
        SubjectEntity subjectEntity = new SubjectEntity(
            UUID.randomUUID(),
            this.courceId,
            this.semesterId,
            this.subjectName
        );
        return subjectEntity;
    }
    
}
