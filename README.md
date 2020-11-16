### demo-annotation 自定义注解
模拟@Value注解，为使用@Value注解的字段设置值，因为最终调用的是com.example.annotation.value.ValueHelper#annotationOperation中的`field.set(bean, v);`，验证了我们使用spring中的@Value修饰的字段不能是private
