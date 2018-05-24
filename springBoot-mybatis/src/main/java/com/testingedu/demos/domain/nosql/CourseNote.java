package com.testingedu.demos.domain.nosql;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "course_note")
@Data
public class CourseNote {
    private String courseId;
    private List<String> knowledge;

}
