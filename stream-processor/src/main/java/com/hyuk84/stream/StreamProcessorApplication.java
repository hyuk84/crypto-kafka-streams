package com.hyuk84.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hyuk84.stream", "com.hyuk84.common"})
public class StreamProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamProcessorApplication.class, args);
    }
}
