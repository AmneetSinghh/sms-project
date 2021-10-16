package com.example.demo.db.view;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;







@Data
@Component
public class MaximumStudentsCourceView {

    private String CourseName;

    private int StudentCount;
}
