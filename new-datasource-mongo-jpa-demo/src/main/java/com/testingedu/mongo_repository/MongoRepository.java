package com.testingedu.mongo_repository;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MongoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    // 使用MongoTemplate 条件查询并且分组统计
    public Map countInvestigationType(InvestigationTimeRequest request) {
        GroupBy groupBy = GroupBy.key("devKeysInternational").initialDocument("{total:0}")
                .reduceFunction("function(doc, prev){prev.total+=1}");

        Criteria criteria = null;

        if (null != request.getCourseId() && StringUtils.isNotBlank(request.getCourseNameChinese())) {
            criteria = Criteria.where("createTime").gte(request.getStartTimestamp()).lte(request.getEndTimestamp()).and("courseId").is(request.getCourseId()).and("courseNameChinese").regex(".*" +request.getCourseNameChinese()+ ".*");

        } else {
            criteria = Criteria.where("createTime").gte(request.getStartTimestamp()).lte(request.getEndTimestamp());

        }

        GroupByResults<BasicDBObject> gbr = mongoTemplate.group(criteria, "online-investigation", groupBy, BasicDBObject.class);

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

        private String courseNameChinese;
        private Long courseId;

        private int page;
        private int size;
    }
}
