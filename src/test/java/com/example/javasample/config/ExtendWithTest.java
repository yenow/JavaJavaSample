package com.example.javasample.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
public class ExtendWithTest {

    @Autowired
    ApplicationContext context;

    @Test
    void test() {
        assert context != null;

        String[] beans = context.getBeanDefinitionNames();
        System.out.println("count = " + context.getBeanDefinitionCount());
        Arrays.asList(beans).forEach(b -> System.out.println("bean = " + b));
    }
}
