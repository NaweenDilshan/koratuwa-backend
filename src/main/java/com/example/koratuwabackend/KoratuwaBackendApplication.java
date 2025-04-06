package com.example.koratuwabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class KoratuwaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KoratuwaBackendApplication.class, args);
    }

}
