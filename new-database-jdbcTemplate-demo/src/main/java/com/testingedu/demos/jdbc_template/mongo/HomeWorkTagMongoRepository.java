package com.testingedu.demos.jdbc_template.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HomeWorkTagMongoRepository extends MongoRepository<HomeWorkTag,String> {
    List<HomeWorkTag> findByPublicationNotIn(List<String> publications);
    List<HomeWorkTag> findByPublicationAndGrade(String publication,String grade);

    HomeWorkTag findByBookSectionId(String courseId);
}
