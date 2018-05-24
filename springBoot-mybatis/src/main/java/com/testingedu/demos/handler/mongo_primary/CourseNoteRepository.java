package com.testingedu.demos.handler.mongo_primary;

import com.testingedu.demos.domain.nosql.CourseNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseNoteRepository extends MongoRepository<CourseNote, String> {
    List<CourseNote> findAll();
}
