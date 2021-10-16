package com.example.demo.db.view;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;




@Data
@Component
public class SearchForStudentView {



    private String name;

    // private int rollNo;

    private String gender;

    private String courseName;

    private String semNo;

}

