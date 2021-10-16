package com.example.demo.db.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @NonNull
    private UUID id;

    @NonNull
    private UUID courceId;

    @NonNull
    private UUID semesterId;

    @NonNull
    private String name;

    @NonNull
    private String rollNo;

    @NonNull
    private String gender;
}


