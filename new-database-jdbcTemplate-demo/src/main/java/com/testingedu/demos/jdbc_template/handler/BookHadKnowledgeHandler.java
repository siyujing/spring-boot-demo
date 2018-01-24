package com.testingedu.demos.jdbc_template.handler;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookHadKnowledgeHandler {

    @Autowired
    @Qualifier(value = "cloudBebaseTemplate")
    JdbcTemplate cloudBebaseTemplate;

    // jdbcTemplate 无参查询方法
    public List<BookHadKnowledgeResponse> findAll() {
        String sql = "SELECT lesson,national_knowledge " +
                "from book_section_label " +
                "where national_knowledge is NOT NULL ";

        return cloudBebaseTemplate.query(sql,
                (resultSet, rowNum) -> {
                    BookHadKnowledgeResponse o = new BookHadKnowledgeResponse();
                    o.setLesson(resultSet.getString("lesson"));
                    o.setNativeKnowledge(resultSet.getString("national_knowledge"));
                    return o;
                });
    }

    // jdbcTemplate 有参查询方法
    public List<BookHadKnowledgeResponse> findByLevelAndType() {
        String sql = "SELECT lesson,national_knowledge " +
                "from book_section_label " +
                "where level = ? and type = ?";

        return cloudBebaseTemplate.query(sql,
                new Object[]{"A", "WORD"},
                (resultSet, rowNum) -> {
                    BookHadKnowledgeResponse o = new BookHadKnowledgeResponse();
                    o.setLesson(resultSet.getString("lesson"));
                    o.setNativeKnowledge(resultSet.getString("national_knowledge"));
                    return o;
                });
    }

    // jdbcTemplate in操作传参
    public List<CourseInfoResponse> findByBookName(List<String> bookName) {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(cloudBebaseTemplate.getDataSource());

        String sql = "select book_section.id,book_section.`projectName` from book_section where book_id IN (select id from book where name in (:ids))";
        Map<String, Object> map = new HashMap<>();
        map.put("ids", bookName);

        List<Map<String, Object>> resultSet = namedParameterJdbcTemplate.queryForList(sql, map);
        List<CourseInfoResponse> responses = new ArrayList<>();
        resultSet.forEach(r -> {
            CourseInfoResponse c = new CourseInfoResponse();
            c.setProjectName((String) r.get("projectName"));
            c.setCourseId((String) r.get("id"));
            responses.add(c);
        });
        return responses;
    }

    @Data
    public static class BookHadKnowledgeResponse {
        private String lesson;
        private String nativeKnowledge;
    }

    @Data
    public static class CourseInfoResponse {
        private String courseId;
        private String projectName;
    }
}
