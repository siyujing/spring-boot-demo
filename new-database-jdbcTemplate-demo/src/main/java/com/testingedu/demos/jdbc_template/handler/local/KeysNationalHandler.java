package com.testingedu.demos.jdbc_template.handler.local;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeysNationalHandler {

    @Autowired
    @Qualifier(value = "jdbcBebaseTemplate")
    JdbcTemplate localBebaseTemplate;


    public List<String> findCourseId(){
        String sql = "SELECT course_id FROM book_national_bak";

        return localBebaseTemplate.query(sql,
                (resultSet, rowNum) -> {
                    return resultSet.getString("course_id");
                });
    }


    @Data
    public static class BookNationalResponse{
        String courseId;
    }
}
