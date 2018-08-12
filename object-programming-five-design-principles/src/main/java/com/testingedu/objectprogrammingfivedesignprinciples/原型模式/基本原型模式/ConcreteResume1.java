package com.testingedu.objectprogrammingfivedesignprinciples.原型模式.基本原型模式;


import com.testingedu.objectprogrammingfivedesignprinciples.utils.FormatUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ConcreteResume1 extends Resume {
    public ConcreteResume1() {
    }

    public ConcreteResume1(String id) {
        this.id = id;
    }

    @Override
    public Resume clone() {
        // 浅克隆
//        ConcreteResume1 result = new ConcreteResume1();
//        result.setId(this.id);
//        return result;

        // 深克隆
        String srt = FormatUtils.toJsonNoException(this);
        try {
            return FormatUtils.fromJson(srt, this.getClass());

        } catch (IOException e) {
            log.info("ConcreteResume1, clone error.");
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {

        return "id:" + id;
    }
}
