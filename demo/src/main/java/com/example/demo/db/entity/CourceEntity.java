package com.example.demo.db.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourceEntity {

    @NonNull
    private UUID id;

    @NonNull
    private String courseName;

    
}
