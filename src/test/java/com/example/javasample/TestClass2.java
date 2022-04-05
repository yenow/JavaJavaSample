package com.example.javasample;

import com.example.javasample.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Component;

@Component
public class TestClass2 {

    @Autowired
    UserRepository userRepository;
}
