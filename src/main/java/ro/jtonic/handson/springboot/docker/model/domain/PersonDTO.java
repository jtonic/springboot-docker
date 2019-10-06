package ro.jtonic.handson.springboot.docker.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Antonel Ernest Pazargic on 06/10/2019.
 *
 * @author Antonel Ernest Pazargic
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDTO {
  
  private String firstName;
  private String lastName;
  private byte age;
}
