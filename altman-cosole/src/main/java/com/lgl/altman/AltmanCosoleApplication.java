package com.lgl.altman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lgl")
public class AltmanCosoleApplication /*extends SpringBootServletInitializer*/ {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(AltmanCosoleApplication.class);
//    }
    public static void main(String[] args) {
        SpringApplication.run(AltmanCosoleApplication.class, args);
    }
}
