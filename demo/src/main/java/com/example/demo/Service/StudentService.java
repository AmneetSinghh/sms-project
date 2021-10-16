package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import com.example.demo.db.view.GenderRatioView;
import com.example.demo.db.view.MaximumStudentsCourceView;
import com.example.demo.db.view.SearchForStudentView;
import com.example.demo.exception.ElementNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public int addStudent(StudentRequest studentRequest){
        int a=-1;
        try{
            a=this.studentRepository.insertStudent(studentRequest.convertToStudentEntity());
            if(a==1){
                System.out.println("added-> the student-> "+ studentRequest.getName()+" "+studentRequest.getGender());
            }
        } catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return a;
    }


    public SearchForStudentView fetch_student(UUID id){
        SearchForStudentView searchForStudentView;
        if(id==null)
            throw new ElementNotFoundException("Id not found");
        searchForStudentView=this.studentRepository.getStudentById(id);
        return searchForStudentView;
    }

    public MaximumStudentsCourceView fetch_maximum_students_cource(){
        MaximumStudentsCourceView maximumStudentsCourceView=this.studentRepository.getMaximumStudentsCource();
        return maximumStudentsCourceView;
    }


   //getGenderRatio 
   public List<GenderRatioView> fetch_gender_ratio(){
    List<GenderRatioView> genderRatioView=this.studentRepository.getGenderRatio();
    return genderRatioView;
}


}
