package com.example.demo.request;

import java.util.UUID;

import com.example.demo.db.entity.CourceEntity;

import lombok.Getter;

@Getter
public class CourceRequest {
    
    private String courseName;

    public boolean validate() {
        if (this.courseName == null ) {
            return false;
        }
        return true;
    }
    
    // convert to entity for transfer to repository;
    public CourceEntity convertToCourceEntity() {
        CourceEntity courceEntity = new CourceEntity(
            UUID.randomUUID(),
            this.courseName
        );
        return courceEntity;
    }
    
}
