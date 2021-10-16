package com.example.demo.request;

import java.util.UUID;

import com.example.demo.db.entity.SemesterEntity;

import lombok.Getter;

@Getter
public class SemesterRequest {
    

    private UUID courceId;

    private String semNo;

    public boolean validate() {
        if (this.courceId== null || this.semNo== null ) {
            return false;
        }
        return true;
    }
    
    // convert to entity for transfer to repository;
    public SemesterEntity convertToSemesterEntity() {
        SemesterEntity semesterEntity = new SemesterEntity(
            UUID.randomUUID(),
            this.courceId,
            this.semNo
        );
        return semesterEntity;
    }
    
}
