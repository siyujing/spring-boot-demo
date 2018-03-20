package com.testingedu.utilsdemo.App.log;

import net.logstash.logback.argument.StructuredArgument;
import org.slf4j.MDC;

import static net.logstash.logback.argument.StructuredArguments.kv;

public class L {

    private static final String USER_ID = "USER_ID";
    private static final String USER_TOKEN = "USER_TOKEN";
    private static final String GROUP_ID = "GROUP_ID";
    private static final String COURSE_ID = "COURSE_ID";
    private static final String DATA = "DATA";

    private static final String REQUEST = "REQUEST";
    private static final String RESPONSE = "RESPONSE";

    private static final String TARGET = "TARGET";
    private static final String FUNCTION = "FUNCTION";
    private static final String INPUT = "INPUT";
    private static final String OUTPUT = "OUTPUT";
    private static final String CONSUME = "CONSUME";

    private static final String BETAG = "BETAG";


    // for context
    public static void clearCustomContext() {
        // could not call MDC.clear(), because X-B3-TraceId will be remove from MDC
        MDC.remove(USER_ID);
        MDC.remove(USER_TOKEN);
        MDC.remove(GROUP_ID);
        MDC.remove(COURSE_ID);
        MDC.remove(DATA);
    }

    public static void clearAndSetContextUserIdAndUserToken(Object userId, Object userToken) {
        clearCustomContext();

        String userIdString = (userId != null) ? userId.toString() : "null";
        String userTokenString = (userToken != null) ? userToken.toString() : "null";
        MDC.put(USER_ID, userIdString);
        MDC.put(USER_TOKEN, userTokenString);
    }

    public static void clearAndSetContextUserId(Object userId) {
        clearCustomContext();

        String userIdString = (userId != null) ? userId.toString() : "null";
        MDC.put(USER_ID, userIdString);
    }

    public static void setContextUserId(Object userId) {
        String userIdString = (userId != null) ? userId.toString() : "null";
        MDC.put(USER_ID, userIdString);
    }

    public static void clearAndSetContextUserToken(Object userToken) {
        clearCustomContext();

        String userTokenString = (userToken != null) ? userToken.toString() : "null";
        MDC.put(USER_TOKEN, userTokenString);
    }

    public static void setContextUserToken(Object userToken) {
        String userTokenString = (userToken != null) ? userToken.toString() : "null";
        MDC.put(USER_TOKEN, userTokenString);
    }

    public static void clearAndSetContextGroupId(Object groupId) {
        clearCustomContext();

        String groupIdString = (groupId != null) ? groupId.toString() : "null";
        MDC.put(GROUP_ID, groupIdString);
    }

    public static void setContextGroupId(Object groupId) {
        String groupIdString = (groupId != null) ? groupId.toString() : "null";
        MDC.put(GROUP_ID, groupIdString);
    }

    public static void clearAndSetContextCourseId(Object courseId) {
        clearCustomContext();

        String courseIdString = (courseId != null) ? courseId.toString() : "null";
        MDC.put(COURSE_ID, courseIdString);
    }

    public static void setContextCourseId(Object courseId) {
        String courseIdString = (courseId != null) ? courseId.toString() : "null";
        MDC.put(COURSE_ID, courseIdString);
    }

    // for variable
    public static StructuredArgument setUserId(Object userId) {
        return (userId != null) ? kv(USER_ID, userId) : kv(USER_ID, "null");
    }

    public static StructuredArgument setUserToken(Object userToken) {
        return (userToken != null) ? kv(USER_TOKEN, userToken) : kv(USER_TOKEN, "null");
    }

    public static StructuredArgument setGroupId(Object groupId) {
        return (groupId != null) ? kv(GROUP_ID, groupId) : kv(GROUP_ID, "null");
    }

    public static StructuredArgument setCourseId(Object courseId) {
        return (courseId != null) ? kv(COURSE_ID, courseId) : kv(COURSE_ID, "null");
    }

    public static StructuredArgument setData(Object data) {
        return (data != null) ? kv(DATA, ">" + data) : kv(DATA, "null");
    }

    // for aspect
    public static StructuredArgument setRequest(Object request) {
        return (request != null) ? kv(REQUEST, request) : kv(REQUEST, "null");
    }

    public static StructuredArgument setResponse(Object response) {
        return (response != null) ? kv(RESPONSE, response) : kv(RESPONSE, "null");
    }

    public static StructuredArgument setTarget(Object target) {
        return (target != null) ? kv(TARGET, target) : kv(TARGET, "null");
    }

    public static StructuredArgument setFunction(Object function) {
        return (function != null) ? kv(FUNCTION, function) : kv(FUNCTION, "null");
    }

    public static StructuredArgument setInput(Object input) {
        return (input != null) ? kv(INPUT, input) : kv(INPUT, "null");
    }

    public static StructuredArgument setOutput(Object output) {
        return (output != null) ? kv(OUTPUT, output) : kv(OUTPUT, "null");
    }

    public static StructuredArgument setConsume(Object consume) {
        return (consume != null) ? kv(CONSUME, consume) : kv(CONSUME, "null");
    }

    // For aliyun ons
    public static StructuredArgument setBeTag(Object beTag) {
        return (beTag != null) ? kv(BETAG, beTag) : kv(BETAG, "null");
    }
}
