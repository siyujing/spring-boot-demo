package com.testingedu.demos.handler.mongo_secondary;

import com.testingedu.demos.domain.nosql.CourseNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseNoteRepositorySec extends MongoRepository<CourseNote, String> {
    List<CourseNote> findAll();
}
