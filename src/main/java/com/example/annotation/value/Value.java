package com.example.annotation.value;

import java.lang.annotation.*;

/**
 * @author 85689
 */
@Documented //作用域javaDoc
@Inherited  //可继承
@Target({ElementType.FIELD, ElementType.METHOD})    //可用于字段和方法上
@Retention(RetentionPolicy.RUNTIME) //存活阶段，运行期间
public @interface Value {
    /**
     * 获取值，格式为：benName.methodName
    */
    String value() default "black";
}
