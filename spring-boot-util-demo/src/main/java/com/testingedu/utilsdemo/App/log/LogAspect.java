package com.testingedu.utilsdemo.App.log;

import com.testingedu.utilsdemo.App.utils.FormatUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    private final String path = "execution(* com.boxfishedu..*Controller.*(..))";


    @Pointcut(path)
    public void anyMethod() {
    }

    @Around(value = "anyMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object object = joinPoint.proceed();
        long span = System.currentTimeMillis() - start;

        if (log.isDebugEnabled()) {
            log.debug("Aspect log.",
                    L.setTarget(joinPoint.getTarget().toString()),
                    L.setFunction(joinPoint.getSignature().toString()),
                    L.setConsume(span),
                    L.setInput((null != args) ? FormatUtils.toJsonNoException(args) : "null"),
                    L.setOutput((null != object) ? FormatUtils.toJsonNoException(object) : "null"));

        } else if (log.isInfoEnabled()) {
            log.info("Aspect log.",
                    L.setTarget(joinPoint.getTarget().toString()),
                    L.setFunction(joinPoint.getSignature().toString()),
                    L.setConsume(span));
        }
        return object;
    }

    @AfterThrowing(value = "anyMethod()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        log.error("Aspect log.",
                L.setTarget(joinPoint.getTarget().toString()),
                L.setFunction(joinPoint.getSignature().toString()),
                e);
    }
}
