package com.testingedu.demos.jdbc_template.handler.local;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSectionKnowledgeHandler {
    @Autowired
    @Qualifier(value = "jdbcBebaseTemplate")
    JdbcTemplate localBebaseTemplate;

    public List<BookSectionKnowledgeResponse> findAll() {
        String sql = "SELECT id,lesson,project_name,version " +
                "from book_section_knowledge ";

        return localBebaseTemplate.query(sql,
                (resultSet, rowNum) -> {
                    BookSectionKnowledgeResponse o = new BookSectionKnowledgeResponse();
                    o.setId(resultSet.getLong("id"));
                    o.setLesson(resultSet.getString("lesson"));
                    o.setProjectName(resultSet.getString("project_name"));
                    o.setVersion(resultSet.getString("version"));
                    return o;
                });
    }

//    public List<BookSectionKnowledgeResponse> findByVersion(String version) {
//        String sql = "SELECT lesson,project_name,version " +
//                "from book_section_knowledge WHERE version LIKE ?";
//
//        return localBebaseTemplate.query(sql,
//                new Object[]{"%" + version + "%"},
//                (resultSet, rowNum) -> {
//                    BookSectionKnowledgeResponse o = new BookSectionKnowledgeResponse();
//                    o.setLesson(resultSet.getString("lesson"));
//                    o.setProjectName(resultSet.getString("project_name"));
//                    o.setVersion(resultSet.getString("version"));
//                    return o;
//                });
//    }


    @Data
    public static class BookSectionKnowledgeResponse {
        private Long id;
        private String lesson;
        private String projectName;
        private String version;

//        private String courseName;                              // 课程名称，中文
//        private String alias;                                   // 课程名称，英文
//        private String cover;                                   // 课程封面
//        private Integer price;                                  // 课程价格
//
//
//        private String publication;
//        private String grade;
//        private String bookSection;
//
//        //语法强序使用
//        private Bundle bundle;
//
//        private Long publicDate;                                // 发布日期
//        private Long lastModified;                              // 修改日期
//
//        private List<String> courseType;                        // 课程类型，内部
//        private List<String> courseTypeV2;                      // 课程类型，显示
//        private List<String> courseLevel;                       // 课程难度
    }


    @Data
    public static class Bundle {

        private String bundleName;

        private String bundleId;

        private Integer bundleOrder;

    }

}
