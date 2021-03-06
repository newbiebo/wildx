package xyz.wildx.commons.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import xyz.wildx.commons.exception.WildxException;
import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class CommonLogAdvice {

    @Around("within(@org.springframework.stereotype.Service *)")
    public Object handleExceptionLog(ProceedingJoinPoint jp) throws Throwable {
        try {
            // 记录方法进入日志
            log.debug("{}方法准备调用，参数: {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
            long a = System.currentTimeMillis();
            // 调用切点方法
            Object result = jp.proceed();
            // 记录方法结束日志
            log.debug("{}方法调用成功，执行耗时{}", jp.getSignature(), System.currentTimeMillis() - a);
            return result;
        } catch (Throwable throwable) {
            log.error("{}方法执行失败，原因：{}", jp.getSignature(), throwable.getMessage(), throwable);
            // 判断异常是否是LyException
            if(throwable instanceof WildxException){
                // 如果是，不处理，直接抛
                throw throwable;
            }else{
                // 如果不是，转为WildxException
                throw new WildxException(500, throwable);
            }
        }
    }
}