package com.hhnail.spring.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hhnail.spring.aop.anno.RecordOperate;
import com.hhnail.spring.aop.convert.ParamConvert;
import com.sun.jndi.ldap.Connection;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// @Component
public class OperateAspect {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1,
            1,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100)
    );

    /**
     * 定义切入点
     * 横切逻辑
     * 织入
     */
    @Pointcut("@annotation(com.hhnail.spring.aop.anno.RecordOperate)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 执行方法得到的结果
        Object result = proceedingJoinPoint.proceed();
        // 线程池异步记录日志，避免记录日志阻断业务
        threadPoolExecutor.execute(() -> {
            try {
                // 拿到切入点的方法签名？？（？？方法签名是啥？？不太懂）
                MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
                // 拿到加了【切入点定义的注解】
                RecordOperate annotation = methodSignature.getMethod().getAnnotation(RecordOperate.class);
                // 获取注解上定义的convert的实例
                Class<? extends ParamConvert> convert = annotation.convert();
                ParamConvert paramConvertInstance = convert.newInstance();
                // 拿到convert实例的入参
                OperateLogDO logDO = paramConvertInstance.convert(proceedingJoinPoint.getArgs()[0]);
                logDO.setDesc(annotation.desc());
                logDO.setResult(result.toString());

                // 模拟日志（可以打印和记录到数据库等等操作）
                System.out.println("insert operate log:" + JSONObject.toJSONString(logDO));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return result;
    }


}
