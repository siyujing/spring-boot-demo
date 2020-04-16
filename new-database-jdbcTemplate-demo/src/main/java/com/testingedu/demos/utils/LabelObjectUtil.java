package com.testingedu.demos.utils;

import com.testingedu.demos.jdbc_template.mongo.CourseLabelEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LabelObjectUtil {
    public static String labelObjectToString(List<CourseLabelEntity.LabelObject> r) {
        List<String> list = new ArrayList<>();

        StringBuffer s = new StringBuffer();
        r.forEach(labelObject -> {
            if (StringUtils.isNotBlank(labelObject.getLevel_1_label())) {
                s.append(labelObject.getLevel_1_label()).append("-");
            }
            if (StringUtils.isNotBlank(labelObject.getLevel_2_label())) {
                s.append(labelObject.getLevel_2_label()).append("-");
            }
            if (StringUtils.isNotBlank(labelObject.getLevel_3_label())) {
                s.append(labelObject.getLevel_3_label()).append("-");
            }
            if (StringUtils.isNotBlank(s)) {
                list.add(s.toString().substring(0, s.length() - 1));
            }
        });
        return list.toString();
    }

    public static String sentenceLabelToString(List<CourseLabelEntity.SentenceLabel> r) {
        List<String> list = new ArrayList<>();

        r.forEach(labelObject -> {
            if (StringUtils.isNotBlank(labelObject.getTheSentencePattern())) {
                list.add(labelObject.getTheSentencePattern());
            }
        });
        return list.toString();
    }

    public static String keysInternalToString(List<CourseLabelEntity.LabelObject> r, String level_1_label) {
        List<String> list = new ArrayList<>();
        StringBuffer s = new StringBuffer();

        for (CourseLabelEntity.LabelObject labelObject : r) {
            if (!StringUtils.equalsIgnoreCase(labelObject.getLevel_1_label(), level_1_label)) {
                continue;
            }

            if (StringUtils.isNotBlank(labelObject.getLevel_1_label())) {
                s.append(labelObject.getLevel_1_label()).append("-");
            }
            if (StringUtils.isNotBlank(labelObject.getLevel_2_label())) {
                s.append(labelObject.getLevel_2_label()).append("-");
            }
            if (StringUtils.isNotBlank(labelObject.getLevel_3_label())) {
                s.append(labelObject.getLevel_3_label()).append("-");
            }
            if (StringUtils.isNotBlank(s)) {
                list.add(s.toString().substring(0, s.length() - 1));
            }
        }

        return list.toString();
    }
}
