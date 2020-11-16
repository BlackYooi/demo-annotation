package com.example.annotation.value;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author 85689
 */
@Configuration
public class ValueHelper implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 根容器为Spring容器
        if(event.getApplicationContext().getParent()==null){
            annotationOperation(event.getApplicationContext());
        }
    }

    private void annotationOperation(ApplicationContext applicationContext){
        // 1,获取有这些注解的类(注解在类上面)
        String[] beanNamesForAnnotation = applicationContext.getBeanNamesForAnnotation(Component.class);
        // 注解在字段上面
        // 2,把实现该注解的操作，本demo的操作是给该注解下面的字段赋值
        for(String beaName : beanNamesForAnnotation){
            Object bean = applicationContext.getBean(beaName);
            Field[] declaredFields = bean.getClass().getDeclaredFields();
            for(Field field : declaredFields){
                if(field.isAnnotationPresent(Value.class)){
                    Value value = field.getAnnotation(Value.class);
                    String v = value.value();
                    try {
                        field.set(bean, v);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
