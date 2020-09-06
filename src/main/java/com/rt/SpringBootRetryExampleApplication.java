package com.rt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SpringBootRetryExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRetryExampleApplication.class, args);
    }

}
