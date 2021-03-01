package cn.youxu.shop.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterFrom {
    //默认是拦截的，添加注解后放行
    boolean value() default true;
}
