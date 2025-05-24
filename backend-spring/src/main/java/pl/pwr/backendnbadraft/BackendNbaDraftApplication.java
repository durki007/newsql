package pl.pwr.backendnbadraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EnableScheduling
public class BackendNbaDraftApplication {

	public static void main(String[] args) {
//		Dotenv dotenv = Dotenv.load();
		SpringApplication.run(BackendNbaDraftApplication.class, args);
	}

}
