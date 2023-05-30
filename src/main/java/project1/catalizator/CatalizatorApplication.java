package project1.catalizator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"project1.config", "project1.handler"})
public class CatalizatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalizatorApplication.class, args);
	}

}
