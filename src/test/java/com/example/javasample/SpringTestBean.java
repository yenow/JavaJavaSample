package com.example.javasample;

import com.example.javasample.domain.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
//@SpringJUnitConfig(SpringJUnitConfigIntegrationTest.Config.class)
public class SpringTestBean {

//    @Autowired
//    private TestInterface testInterface;

    @Autowired
    private UserRepository userRepository;
//    private TestClass2 testClass2;

    @Test
    void test() {
//        Assertions.assertNotNull(testInterface);
        Assertions.assertNotNull(userRepository);
//        Assertions.assertNotNull(testClass2);
//        Assertions.assertNotNull(testClass2.userRepository);
    }
}
