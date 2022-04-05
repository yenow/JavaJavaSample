package com.example.javasample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(SpringJUnitConfigIntegrationTest.Config.class)
public class SpringJUnitConfigIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TestInterface testInterface;

    @Test
    void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
        assertNotNull(applicationContext);
        String[] beans = applicationContext.getBeanDefinitionNames();
        System.out.println("count = " + applicationContext.getBeanDefinitionCount());
        Arrays.asList(beans).forEach(b -> System.out.println("bean = " + b));

        System.out.println("testInterace =" + testInterface);
    }

    @Configuration
    static public class Config {

        @Bean
        public TestInterface testInterface() {
            return new TestClass();
        }

        @Bean
        public TestClass2 testClass2() {
            return new TestClass2();
        }
    }
}
