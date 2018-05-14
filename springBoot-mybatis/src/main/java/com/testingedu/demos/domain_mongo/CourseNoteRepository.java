package com.testingedu.demos.domain_mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseNoteRepository extends MongoRepository<CourseNote, String> {
    CourseNote findOne();
}
