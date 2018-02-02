package com.testingedu.handler;


import com.testingedu.domain.nosql.CourseLabelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseLabelHandler {
    @Autowired
    MongoTemplate mongoTemplate;


    public void findCourseIdByCourseNameChinese() {

    }

    public CourseLabelEntity findOneByCourseNameChinese(String courseNameChinese) {
        Query query = new Query();
        Query entity = query.addCriteria(Criteria.where("courseNameChinese").is(courseNameChinese));
        CourseLabelEntity one = mongoTemplate.findOne(entity, CourseLabelEntity.class);

        System.out.println("one:"+one);
        return one;
    }

    public List<CourseLabelEntity> findByCourseNameChinese(String courseNameChinese) {
        Query query = new Query();
        Query entityQuery = query.addCriteria(Criteria.where("courseNameChinese").is(courseNameChinese));
        List<CourseLabelEntity> one = mongoTemplate.find(entityQuery,CourseLabelEntity.class);

        System.out.println("one:"+one);
        return one;
    }
}
