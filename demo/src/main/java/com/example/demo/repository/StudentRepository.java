package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.demo.db.entity.CourceEntity;
import com.example.demo.db.entity.SemesterEntity;
import com.example.demo.db.entity.StudentEntity;
import com.example.demo.db.entity.SubjectEntity;
import com.example.demo.db.view.GenderRatioView;
import com.example.demo.db.view.MaximumStudentsCourceView;
import com.example.demo.db.view.SearchForStudentView;
import com.example.demo.request.SubjectRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;




@Component
public class StudentRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int insertStudent(StudentEntity student){
         String query = "INSERT INTO student"
                + " (id, \"courceId\", \"semesterId\", \"name\", \"rollNo\", \"gender\")"
                + " VALUES (:id, :courceId, :semesterId, :name, :rollNo, :gender)";
        Map <String, Object> params = new HashMap <String, Object>();
        params.put("id", student.getId());
        params.put("courceId", student.getCourceId());
        params.put("semesterId", student.getSemesterId());
        params.put("name", student.getName());
        params.put("rollNo", student.getRollNo());
        params.put("gender", student.getGender());

        return namedParameterJdbcTemplate.update(query, params);
    }



    public SearchForStudentView getStudentById(UUID id) {
        // String query = "SELECT u.id as \"userId\", ur.id as \"userRoleId\","
        //     + " u.name as name, u.\"phoneNumber\" as \"phoneNumber\", ur.role as role,"
        //     + " u.\"createdAt\" as \"userCreatedAt\", ur.\"createdAt\" as \"userRoleCreatedAt\""
        //     + " FROM user_roles ur"
        //     + " JOIN users u ON u.id = ur.\"userId\""
        //     + " WHERE ur.id = :id"
        //     + " AND ur.\"deletedAt\" is NULL";


        System.out.println("Reacted here");
        String query="SELECT t1.name, t1.gender, t2.\"courseName\", t3.\"semNo\" from student t1 JOIN cource t2 on t1.\"courceId\"=t2.id JOIN semester t3 on t1.\"semesterId\"=t3.\"id\" where t1.id=:id";

        Map <String, Object> params = new HashMap <String, Object>();
        params.put("id", id);
        List <SearchForStudentView> students = namedParameterJdbcTemplate.query(
                query,
                params,
                new RowMapper<SearchForStudentView>() {
            @Override
            public SearchForStudentView mapRow(ResultSet rs, int rowNum) throws SQLException {
                SearchForStudentView student = new SearchForStudentView();
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setCourseName(rs.getString("courseName"));
                student.setSemNo(rs.getString("semNo"));
                return student;
            }
        });
        return students.isEmpty() ? null : students.get(0);
    }

//sms=> select t2."courseName", count(t1.id) from student t1 JOIN cource t2 on t1."courceId"=t2.id group by t1."courceId",t2."courseName";

    public MaximumStudentsCourceView getMaximumStudentsCource(){


        System.out.println("Reacted here");
        String query="select t2.\"courseName\", count(t1.id) as \"StudentCount\" from student t1 JOIN cource t2 on t1.\"courceId\"=t2.id group by t1.\"courceId\",t2.\"courseName\" order by \"StudentCount\" DESC";

        Map <String, Object> params = new HashMap <String, Object>();
        List <MaximumStudentsCourceView> students = namedParameterJdbcTemplate.query(
                query,
                params,
                new RowMapper<MaximumStudentsCourceView>() {
            @Override
            public MaximumStudentsCourceView mapRow(ResultSet rs, int rowNum) throws SQLException {
                MaximumStudentsCourceView student = new MaximumStudentsCourceView();
                student.setCourseName(rs.getString("courseName"));
                student.setStudentCount(rs.getInt("Studentcount"));
                return student;
            }
        });
        return students.isEmpty() ? null : students.get(0);


    }

  //select student."gender", ROUND((count(student."id")*100.0/ (select count(student."id") from student)),2)  as "Gender Count" from student  group by student."gender";
  


    public List<GenderRatioView> getGenderRatio(){


        System.out.println("Reacted here");
        String query="select student.\"gender\", ROUND((count(student.\"id\")*100.0/ (select count(student.\"id\") from student)),2)  as \"Gender_Count\" from student  group by student.\"gender\"  ";

        Map <String, Object> params = new HashMap <String, Object>();
        List <GenderRatioView> students = namedParameterJdbcTemplate.query(
                query,
                params,
                new RowMapper<GenderRatioView>() {
            @Override
            public GenderRatioView mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenderRatioView student = new GenderRatioView();
                student.setGender(rs.getString("gender"));
                student.setPercentage(rs.getInt("Gender_Count"));
                return student;
            }
        });

        return students.isEmpty() ? null : students;


    }

}



