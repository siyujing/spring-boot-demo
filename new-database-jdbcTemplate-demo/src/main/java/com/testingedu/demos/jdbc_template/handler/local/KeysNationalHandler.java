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
        String sql = "SELECT course_id FROM homework_book_national";

        return localBebaseTemplate.query(sql,
                (resultSet, rowNum) -> {
                    return resultSet.getString("course_id");
                });
    }

    public List<String> findPublication(){
        String sql = "SELECT publication FROM homework_book_national";

        return localBebaseTemplate.query(sql,
                (resultSet, rowNum) -> {
                    return resultSet.getString("publication");
                });
    }


    @Data
    public static class BookNationalResponse{
        private String courseId;
        private String publication;
    }
}
