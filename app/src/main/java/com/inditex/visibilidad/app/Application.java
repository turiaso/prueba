package com.inditex.visibilidad.app;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inditex.prices")
public class Application {
    public static void main(final String... args) {
        run(Application.class, args);
    }
}