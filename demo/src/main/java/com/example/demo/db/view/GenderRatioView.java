package com.example.demo.db.view;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;







@Data
@Component
public class GenderRatioView {

    private String Gender;

    private int percentage;
}
