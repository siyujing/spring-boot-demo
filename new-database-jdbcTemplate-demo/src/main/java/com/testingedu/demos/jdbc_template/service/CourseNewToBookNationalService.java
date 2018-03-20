package com.testingedu.demos.jdbc_template.service;

import com.testingedu.demos.jdbc_template.domain.KeysNationalEntity;
import com.testingedu.demos.jdbc_template.domain.KeysNationalRepository;
import com.testingedu.demos.jdbc_template.handler.local.KeysNationalHandler;
import com.testingedu.demos.jdbc_template.mongo.CourseNew;
import com.testingedu.demos.jdbc_template.mongo.CourseNewMongoRepository;
import com.testingedu.demos.jdbc_template.mongo.HomeWorkTag;
import com.testingedu.demos.jdbc_template.mongo.HomeWorkTagMongoRepository;
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
    HomeWorkTagMongoRepository homeWorkTagMongoRepository;

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
                log.error("save file [{}]", h.getBookSectionId(), e);
            }
        });
        keysNationalRepository.save(result);
        log.info("save all success!");
    }

    public void saveHomeworkLongZeToBookNational() {
        List<KeysNationalEntity> result = new ArrayList<>();
        List<String> publications = keysNationalHandler.findPublication();
        List<HomeWorkTag> homeWorkTags = homeWorkTagMongoRepository.findByPublicationNotIn(publications);
        List<String> label= new ArrayList<>();
        homeWorkTags.forEach(homeWorkTag -> {
            try {
                KeysNationalEntity keysNationalEntity = new KeysNationalEntity();
                keysNationalEntity.fromHomework(homeWorkTag);

                DateTime now = DateTime.now();
                keysNationalEntity.setCreateTime(now);
                keysNationalEntity.setUpdateTime(now);
                result.add(keysNationalEntity);
            }catch (Exception e){
                label.add(homeWorkTag.getPublication()+","+homeWorkTag.getBookSectionId());
                log.error("save file [{}]", homeWorkTag.getBookSectionId(), e);
            }
        });
        keysNationalRepository.save(result);
        log.info("save all success!");
        log.info("be not save courses [{}],[{}]",label.size(),label);
    }

    public void saveHomeworkLongZeToBookNationalByPub() {
        List<KeysNationalEntity> result = new ArrayList<>();
//        List<String> publications = keysNationalHandler.findPublication();
//        List<HomeWorkTag> homeWorkTags = homeWorkTagMongoRepository.findByPublicationNotIn(publications);
        List<HomeWorkTag> homeWorkTags = homeWorkTagMongoRepository.findByPublicationAndGrade("牛津粤教版","九下");
        List<String> label= new ArrayList<>();
        homeWorkTags.forEach(homeWorkTag -> {
            try {
                KeysNationalEntity keysNationalEntity = new KeysNationalEntity();
                keysNationalEntity.fromHomework(homeWorkTag);

                DateTime now = DateTime.now();
                keysNationalEntity.setCreateTime(now);
                keysNationalEntity.setUpdateTime(now);
                result.add(keysNationalEntity);
            }catch (Exception e){
                label.add(homeWorkTag.getPublication()+","+homeWorkTag.getBookSectionId());
                log.error("save file [{}]", homeWorkTag.getBookSectionId(), e);
            }
        });
        keysNationalRepository.save(result);
        log.info("save all success!");
        log.info("be not save courses [{}],[{}]",label.size(),label);
    }
}
