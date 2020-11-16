package com.example.annotation.value;
import org.springframework.stereotype.Component;

/**
 * @author 85689
 */
@Component
public class Demo {

    @Value(value = "xi")
    String black;

    public String getBlack() {
        return black;
    }
}
