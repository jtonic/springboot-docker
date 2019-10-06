package ro.jtonic.handson.springboot.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDockerApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDockerApplication.class);

	@GetMapping
	public String greeting() {
		LOGGER.debug("Hello from rest-controller");
		return "Hello SpringBoot funs!!!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}
}
