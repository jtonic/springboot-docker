package ro.jtonic.handson.springboot.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.jtonic.handson.springboot.docker.model.domain.Person;
import ro.jtonic.handson.springboot.docker.model.domain.PersonDTO;
import ro.jtonic.handson.springboot.docker.model.mapping.PersonMapper;

@SpringBootApplication
@RestController
public class SpringbootDockerApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDockerApplication.class);
	
	private PersonMapper personMapper;
	
	public SpringbootDockerApplication(PersonMapper personMapper) {
		
		this.personMapper = personMapper;
	}

	@GetMapping
	public PersonDTO greeting() {
		
		final Person person = Person.builder().firstName("Antonel").lastName("Pazaric").age((byte) 49).build();
		final PersonDTO personDTO = personMapper.mapToPersonDTO(person);
		LOGGER.debug(String.format("Hi %s", personDTO));
		return personDTO;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerApplication.class, args);
	}
}
