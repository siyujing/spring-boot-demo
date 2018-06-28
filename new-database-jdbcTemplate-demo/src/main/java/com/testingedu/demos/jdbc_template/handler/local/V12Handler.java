package com.testingedu.demos.jdbc_template.handler.local;

import com.testingedu.demos.jdbc_template.domain.BookSectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class V12Handler {

    @Autowired
    @Qualifier(value = "jdbcBebaseTemplate")
    JdbcTemplate localBebaseTemplate;

    public void saveTop(List<BookSectionEntity> bookSectionEntitys) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(localBebaseTemplate.getDataSource());

        for (BookSectionEntity bookSectionEntity : bookSectionEntitys) {
            String sql = "insert into `course_candidate_recommend_top`(course_id,project_name,type,grade,grade_index,bundle) VALUE(:course_id,:project_name,:type,:grade,:grade_index,:bundle);";
            Map<String, Object> map = new HashMap<>();
            map.put("course_id", bookSectionEntity.getCourseId());
            map.put("project_name",bookSectionEntity.getProjectName());
            map.put("type", bookSectionEntity.getType());
            map.put("grade", bookSectionEntity.getGrade());
            map.put("grade_index", bookSectionEntity.getGradeIndex());
            map.put("bundle", bookSectionEntity.getBundle());

            int result = namedParameterJdbcTemplate.update(sql, map);
        }
    }
}
