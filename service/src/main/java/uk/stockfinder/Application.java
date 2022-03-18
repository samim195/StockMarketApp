package uk.stockfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("I am Roqia Amiry");
        System.out.println("I am 21 years old and I live in the UK");
        SpringApplication.run(Application.class, args);
    }
}
