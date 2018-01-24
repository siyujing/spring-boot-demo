package com.testingedu.demos.jdbc_template.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by boxfish on 18/1/5.
 */
public interface CourseLabelMongoRepository extends MongoRepository<CourseLabelEntity,String> {
    List<CourseLabelEntity> findByCourseIdIn(List<String> courseIds);
}
