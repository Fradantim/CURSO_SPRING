package edu.educacionit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Init {
    public static void main(String[] args) {
        SpringApplication.run(Init.class, args);
    }
}

@Component
class AppStartupRunner implements ApplicationRunner {
    public void run(ApplicationArguments args) {
        System.out.println("Startup ...");
    }
}

