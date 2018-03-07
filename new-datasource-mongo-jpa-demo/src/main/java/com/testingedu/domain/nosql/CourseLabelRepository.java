package com.testingedu.domain.nosql;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseLabelRepository extends MongoRepository<CourseLabelEntity,String> {

    List<CourseLabelEntity> findByCourseNameChinese(String name);

    Page<CourseLabelEntity> findByCourseNameChinese(String name, Pageable pageable);
}
