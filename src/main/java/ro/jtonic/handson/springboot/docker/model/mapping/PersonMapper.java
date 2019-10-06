package ro.jtonic.handson.springboot.docker.model.mapping;

import org.mapstruct.Mapper;
import ro.jtonic.handson.springboot.docker.model.domain.Person;
import ro.jtonic.handson.springboot.docker.model.domain.PersonDTO;

/**
 * Created by Antonel Ernest Pazargic on 06/10/2019.
 *
 * @author Antonel Ernest Pazargic
 */
@Mapper
public interface PersonMapper {
  
  PersonDTO mapToPersonDTO(Person person);
  
  Person mapToPerson(PersonDTO personDTO);
}
