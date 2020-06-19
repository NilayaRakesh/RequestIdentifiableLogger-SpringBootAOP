package com.nr.identifiablelogging.annotation;

import com.nr.identifiablelogging.util.ThreadLocalUtil;
import com.nr.identifiablelogging.util.UuidUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogIdSetupAspect {


    @Before("execution(* com.nr.identifiablelogging..*.*(..)) && @annotation(com.nr.identifiablelogging.annotation.IdentifiableLogging)")
    public void setLogIdToThreadLocal(JoinPoint call) {
        MethodSignature signature = (MethodSignature) call.getSignature();
        Method method = signature.getMethod();
        IdentifiableLogging annotation = method.getAnnotation(IdentifiableLogging.class);
        String logId = annotation.value();
        boolean skipUuid = annotation.skipUuid();
        if (!skipUuid) {
            logId = new String(
                        new StringBuilder(logId).append("-").append(UuidUtil.getRandomUuid()));
        }

        ThreadLocalUtil.setLogId(logId);
    }


    @After("execution(* com.nr.identifiablelogging..*.*(..)) && @annotation(com.nr.identifiablelogging.annotation.IdentifiableLogging)")
    public void removeLogIdFromThreadLocal(JoinPoint call) {
        ThreadLocalUtil.removeLogId();
    }
}
