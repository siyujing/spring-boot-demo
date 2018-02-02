package com.testingedu.handler;


import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.testingedu.domain.nosql.CourseLabelEntity;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CourseLabelHandler {
    @Autowired
    MongoTemplate mongoTemplate;


    public void findCourseIdByCourseNameChinese() {

    }

    public CourseLabelEntity findOneByCourseNameChinese(String courseNameChinese) {
        Query query = new Query();
        Query entity = query.addCriteria(Criteria.where("courseNameEnglish").is(courseNameChinese));
        CourseLabelEntity one = mongoTemplate.findOne(entity, CourseLabelEntity.class);

        System.out.println("one:"+one);
        return one;
    }

    public List<CourseLabelEntity> findByCourseNameChinese(String courseNameChinese) {
        Query query = new Query();
        Query entityQuery = query.addCriteria(Criteria.where("courseNameEnglish").is(courseNameChinese));
        List<CourseLabelEntity> one = mongoTemplate.find(entityQuery,CourseLabelEntity.class);

        System.out.println("one:"+one);
        return one;
    }


    // 使用MongoTemplate 条件查询并且分组统计
    public Map countInvestigationType(InvestigationTimeRequest request) {
        GroupBy groupBy = GroupBy.key("devKeysInternational").initialDocument("{total:0}")
                .reduceFunction("function(doc, prev){prev.total+=1}");

        Criteria criteria = null;

        if (null != request.getCourseId() && StringUtils.isNotBlank(request.getCourseNameEnglish())) {
            criteria = Criteria.where("createTime").gte(request.getStartTimestamp()).lte(request.getEndTimestamp()).and("courseId").is(request.getCourseId()).and("courseNameEnglish").regex(".*" +request.getCourseNameEnglish()+ ".*");

        } else {
            criteria = Criteria.where("createTime").gte(request.getStartTimestamp()).lte(request.getEndTimestamp());

        }

        GroupByResults<BasicDBObject> gbr = mongoTemplate.group(criteria, "course_label_syj", groupBy, BasicDBObject.class);

        BasicDBList list = (BasicDBList) gbr.getRawResults().get("retval");
        Map result = new HashMap<>();

        for (Object aList : list) {
            BasicDBObject obj = (BasicDBObject) aList;
            if (CollectionUtils.isNotEmpty((List) obj.get("devKeysInternational"))) {
                List<String> newList = new ArrayList<>();
                ((List) obj.get("devKeysInternational")).forEach(l -> newList.add(l.toString()));
                result.put(newList, obj.get("total"));
            }
        }
        return result;
    }


    @Data
    public static class InvestigationTimeRequest {
        private DateTime startTimestamp;
        private DateTime endTimestamp;

        private String courseNameEnglish;
        private Long courseId;

        public InvestigationTimeRequest(DateTime startTimestamp, DateTime endTimestamp, String courseNameEnglish, Long courseId){
            this.startTimestamp = startTimestamp;
            this.endTimestamp = endTimestamp;
            this.courseNameEnglish = courseNameEnglish;
            this.courseId =courseId;
        }

        public InvestigationTimeRequest(){

        }
    }
}
