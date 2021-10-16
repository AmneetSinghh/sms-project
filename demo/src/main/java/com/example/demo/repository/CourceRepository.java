package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.db.entity.CourceEntity;
import com.example.demo.db.entity.SemesterEntity;
import com.example.demo.db.entity.SubjectEntity;
import com.example.demo.request.SubjectRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;




@Component
public class CourceRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int insertCource(CourceEntity cource){
         String query = "INSERT INTO cource"
                + " (id, \"courseName\")"
                + " VALUES (:id, :courseName)";
        Map <String, Object> params = new HashMap <String, Object>();
        params.put("id", cource.getId());
        params.put("courseName", cource.getCourseName());
        return namedParameterJdbcTemplate.update(query, params);
    }


    public int insertSemester(SemesterEntity semester){ 
        String query = "INSERT INTO semester"
               + " (id, \"courceId\", \"semNo\")"
               + " VALUES (:id, :courceId, :semNo)";
       Map <String, Object> params = new HashMap <String, Object>();
       params.put("id", semester.getId());
       params.put("courceId", semester.getCourceId());
       params.put("semNo", semester.getSemNo());
       return namedParameterJdbcTemplate.update(query, params);
   }


    public int insertSubject(SubjectEntity subject){ 
       String query = "INSERT INTO subject"
           + " (id, \"courceId\", \"semesterId\", \"subjectName\")"
           + " VALUES (:id, :courceId, :semesterId, :subjectName)";
        Map <String, Object> params = new HashMap <String, Object>();
        params.put("id", subject.getId());
        params.put("courceId", subject.getCourceId());
        params.put("semesterId",subject.getSemesterId() );
        params.put("subjectName",subject.getSubjectName() );
        return namedParameterJdbcTemplate.update(query, params);
    }
  
  


    


}



