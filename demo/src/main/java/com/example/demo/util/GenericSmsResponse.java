package com.example.demo.util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericSmsResponse {
    
    private String status;

    private String message;

    private Object payload;
}