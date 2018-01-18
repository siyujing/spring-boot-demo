package com.testingedu.demos.jdbc_template.handler;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
                new Object[]{"A","WORD"},
                (resultSet, rowNum) -> {
                    BookHadKnowledgeResponse o = new BookHadKnowledgeResponse();
                    o.setLesson(resultSet.getString("lesson"));
                    o.setNativeKnowledge(resultSet.getString("national_knowledge"));
                    return o;
                });
    }

    @Data
    public static class BookHadKnowledgeResponse {
        private String lesson;
        private String nativeKnowledge;
    }
}