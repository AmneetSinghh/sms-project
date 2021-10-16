package com.example.demo.Service;

import com.example.demo.repository.CourceRepository;
import com.example.demo.request.CourceRequest;
import com.example.demo.request.SemesterRequest;
import com.example.demo.request.SubjectRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourceService {

    @Autowired
    private CourceRepository courceRepository;

    public int addCource(CourceRequest courceRequest){
        int a=-1;
        try{
            a=this.courceRepository.insertCource(courceRequest.convertToCourceEntity());
            if(a==1){
                System.out.print("added-> the cource-> "+ courceRequest.getCourseName());
            }
        } catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return a;
    }

    public int addSemester(SemesterRequest semesterRequest){
        int a=-1;
        try{
            a=this.courceRepository.insertSemester(semesterRequest.convertToSemesterEntity());
            if(a==1){
                System.out.println("added-> the semester-> "+ semesterRequest.getCourceId()+" "+semesterRequest.getSemNo());
            }
        } catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return a;
    }

    public int addSubject(SubjectRequest subjectRequest){
        int a=-1;
        try{
            a=this.courceRepository.insertSubject(subjectRequest.convertToSubjectEntity());
            if(a==1){
                System.out.println("added-> the subject-> "+ subjectRequest.getSubjectName());
            }
        } catch(Exception e){
            e.printStackTrace();
            return -1;
        }
        return a;
    }
    
}
