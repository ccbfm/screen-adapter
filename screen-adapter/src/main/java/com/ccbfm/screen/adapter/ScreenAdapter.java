package com.ccbfm.screen.adapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScreenAdapter {
    int value() default ScreenAdapterManager.DEFAULT_DPI;
}
