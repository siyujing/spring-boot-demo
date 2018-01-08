package com.testingedu.domain.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by boxfish on 18/1/8.
 */
public interface CourseLabelRepository extends MongoRepository<CourseLabelEntity,String> {
    List<CourseLabelEntity> findByCourseNameChinese(String name);
}
