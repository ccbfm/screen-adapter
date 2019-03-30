package com.ccbfm.screen.adapter;

import android.app.Activity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ScreenAdapterAspect {

    @Pointcut("execution(@com.ccbfm.screen.adapter.ScreenAdapter * android.app.Activity+.onCreate(..))")
    public void pointcutActivity() {
    }

    @Around("pointcutActivity()")
    public void screenAdapterExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        if (target instanceof Activity) {
            int targetScreenDpi = ScreenAdapterManager.DEFAULT_DPI;
            if (joinPoint.getSignature() instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                ScreenAdapter screenAdapter = methodSignature.getMethod().getAnnotation(ScreenAdapter.class);
                int screenDpi = screenAdapter.value();
                if (screenDpi > 0) {
                    targetScreenDpi = screenDpi;
                }
            }
            ScreenAdapterTools.adaptScreen((Activity) target, targetScreenDpi);
        }

        joinPoint.proceed();
    }
}
