package com.testingedu.demos.jdbc_template.service;

import com.testingedu.demos.jdbc_template.domain.KeysNationalEntity;
import com.testingedu.demos.jdbc_template.domain.KeysNationalRepository;
import com.testingedu.demos.jdbc_template.handler.local.KeysNationalHandler;
import com.testingedu.demos.jdbc_template.mongo.CourseNew;
import com.testingedu.demos.jdbc_template.mongo.CourseNewMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CourseNewToBookNationalService {

    @Autowired
    CourseNewMongoRepository courseNewMongoRepository;

    @Autowired
    KeysNationalHandler keysNationalHandler;

    @Autowired
    KeysNationalRepository keysNationalRepository;

    public void saveCourseNewToBookNational() {
        List<String> courseIds = keysNationalHandler.findCourseId();

        List<CourseNew> homeworkCollection = courseNewMongoRepository.findByBookSectionIdNotIn(courseIds);

        List<KeysNationalEntity> result = new ArrayList<>();
        homeworkCollection.forEach(h -> {
            try {
                KeysNationalEntity entity = new KeysNationalEntity();
                entity.fromCourseNew(h);

                DateTime now = DateTime.now();
                entity.setCreateTime(now);
                entity.setUpdateTime(now);
                result.add(entity);
                log.info("save success [{}]", h.getBookSectionId());
            } catch (Exception e) {
                log.error("save file [{}]", h.getBookSectionId(),e);
            }
        });
        keysNationalRepository.save(result);
        log.info("save all success!");
    }
}
