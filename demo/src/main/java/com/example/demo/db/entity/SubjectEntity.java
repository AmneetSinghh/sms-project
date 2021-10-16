package com.example.demo.db.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {

    @NonNull
    private UUID id;

    @NonNull
    private UUID courceId;

    @NonNull
    private UUID semesterId;

    @NonNull
    private String subjectName;

    
}



