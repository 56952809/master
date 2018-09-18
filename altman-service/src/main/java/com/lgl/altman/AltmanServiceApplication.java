package com.lgl.altman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lgl")
public class AltmanServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AltmanServiceApplication.class, args);
    }
}
