package com.testingedu.demos.service_demo;

import com.testingedu.demos.domain.nosql.CourseNote;
import com.testingedu.demos.handler.mongo_primary.CourseNoteRepository;
import com.testingedu.demos.handler.mongo_secondary.CourseNoteRepositorySec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseNoteService {
    @Autowired
    private CourseNoteRepository courseNoteRepository;
    @Autowired
    private CourseNoteRepositorySec courseNoteRepositorySec;


    public List<CourseNote> testMongo() {
        List<CourseNote> all = courseNoteRepository.findAll();
        return all;
    }

    public List<CourseNote> testMongoSec() {
        List<CourseNote> all = courseNoteRepositorySec.findAll();
        return all;
    }
}
