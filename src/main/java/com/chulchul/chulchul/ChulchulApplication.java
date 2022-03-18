package com.chulchul.chulchul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChulchulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChulchulApplication.class, args);
    }

}
