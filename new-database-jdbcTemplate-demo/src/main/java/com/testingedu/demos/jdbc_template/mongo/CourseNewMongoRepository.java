package com.testingedu.demos.jdbc_template.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseNewMongoRepository extends MongoRepository<CourseNew,String>{
    List<CourseNew> findByBookSectionIdNotIn(List<String> courseId);

    List<CourseNew> findByBookSectionIdIn(List<String> courseId);

}
