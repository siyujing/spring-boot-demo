package com.testingedu.demos.jdbc_template.service;

import com.testingedu.demos.jdbc_template.domain.HomeworkCandidateCoursesEntity;
import com.testingedu.demos.jdbc_template.domain.HomeworkCandidateCoursesRepository;
import com.testingedu.demos.jdbc_template.mongo.HomeWorkTag;
import com.testingedu.demos.jdbc_template.mongo.HomeWorkTagMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ReviewService {
    @Autowired
    HomeworkCandidateCoursesRepository homeworkCandidateCoursesRepository;
    @Autowired
    HomeWorkTagMongoRepository homeWorkTagMongoRepository;

    public void review() {
        List<HomeworkCandidateCoursesEntity> all = homeworkCandidateCoursesRepository.findAll();
        List<String> publication = new ArrayList<>();
        List<Long> forUpdateId = new ArrayList<>();

        all.forEach(a -> {
            HomeWorkTag homeworkTag = homeWorkTagMongoRepository.findByBookSectionId(a.getCourseId());
            if (a.getPublication().equals("北京版") || a.getPublication().equals("新起点一年级起")) {
                if (Objects.nonNull(homeworkTag)) {
                    if (!Objects.equals(a.getBookSection(), homeworkTag.getBookSection())) {
                        a.setBookSection(homeworkTag.getBookSection());
                        homeworkCandidateCoursesRepository.save(a);

                        publication.add(a.getPublication());
                        forUpdateId.add(a.getId());
                        log.info("update one [{}],[{}]", a.getId(), a.getBookSection());
                    }
                }
            }else {
                if (Objects.nonNull(homeworkTag)) {
                    if (!Objects.equals(a.getBookSection(), homeworkTag.getBookSection())) {
                        publication.add(a.getPublication());
                        forUpdateId.add(a.getId());
                        log.info("不同的 [{}],[{}]", a.getId(), a.getBookSection());
                    }
                }
            }
        });

        System.out.println("publication=" + publication);
        System.out.println("forUpdateId=" + forUpdateId);
    }

}
