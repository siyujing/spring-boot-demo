package com.testingedu.service;

import com.testingedu.domain.nosql.CourseLabelEntity;
import com.testingedu.domain.nosql.CourseLabelRepository;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseLabelService {

    @Autowired
    CourseLabelRepository courseLabelRepository;

    // mongo 分页查询
    public void getCourseLabelEntity(EvaluationTimeRequest request){

        Pageable pageable = new PageRequest(request.getPage(), request.getSize(), new Sort(Sort.Direction.ASC, "courseId"));
        Page<CourseLabelEntity> pageCourseEvaluationEntity = courseLabelRepository.findByCourseNameChinese("testOne2", pageable);

        long totalPages = (long) pageCourseEvaluationEntity.getTotalPages();
        System.out.println("总页数="+totalPages);

        Long totalElements = pageCourseEvaluationEntity.getTotalElements();
        System.out.println("总元素数="+totalElements);

        pageCourseEvaluationEntity.forEach(entity -> System.out.println(entity.getCourseNameChinese()));
    }

    public void updateLabel(){
        List<CourseLabelEntity> all = courseLabelRepository.findAll();
        all.forEach(a->{
            DateTime now = DateTime.now();
            a.setCreateTime(now);
            a.setUpdateTime(now);
            courseLabelRepository.save(a);
        });
    }

    @Data
    public static class EvaluationTimeRequest {
        private int page;
        private int size;
    }
}
