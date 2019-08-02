package com.darkcode.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestApplication {

    public static final String FrontEnd = "http://localhost:4200";

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }

}
