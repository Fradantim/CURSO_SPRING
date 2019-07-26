package edu.educacionit.primerms;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PrimermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimermsApplication.class, args);
	}

}

@Component
class AppStartupRunner implements ApplicationRunner {
    public void run(ApplicationArguments args) {
        System.out.println("Inicio de Applicacion");
    }
}
