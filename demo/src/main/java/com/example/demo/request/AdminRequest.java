package com.example.demo.request;

import java.util.UUID;

import com.example.demo.db.entity.AdminEntity;

import lombok.Getter;

@Getter
public class AdminRequest {
    
    private String name;

    private String password;

    public boolean validate() {
        if (this.name == null || this.password== null ) {
            return false;
        }
        return true;
    }

    // convert to entity for transfer to repository;
    public AdminEntity convertToAdminEntity() {
        AdminEntity adminEntity = new AdminEntity(
            UUID.randomUUID(),
            this.name,
            this.password
        );
        return adminEntity;
    }
    
}
