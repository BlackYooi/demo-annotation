package com.example.annotation;

import com.example.annotation.value.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnotationApplication.class)
public class AnnotationApplicationTests {

    @Autowired
    Demo demo;

    @Test
    public void testValue(){
        String s = demo.getBlack();
        System.out.println();
    }

}
