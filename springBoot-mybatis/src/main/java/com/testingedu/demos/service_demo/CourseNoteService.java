package com.testingedu.demos.service_demo;

import com.testingedu.demos.domain_mongo.CourseNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseNoteService {
    @Autowired
    private CourseNoteRepository courseNoteRepository;


    public void testMongo() {
        courseNoteRepository.findOne();
    }
}
