package ro.jtonic.handson.springboot.docker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ComponentTag
class SpringbootDockerApplicationTests {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDockerApplicationTests.class);
	
	private static String[][] personInfoProvider() {
		return new String[][] {
				{"1", "jtonic"},
				{"2", "rubita"},
				{"3", "tutye"},
		};
	}
	
	@DisplayName("should print all names")
	@ParameterizedTest(name = "{index} ==> uuid=''{0}'', name=''{1}''")
	@MethodSource("personInfoProvider")
	void contextLoads(String uuid, String name) {
		LOGGER.debug(String.format("Person info:\n\tuuid=%s\tName: %s", uuid, name));
		Assertions.assertTrue(true);
	}
	
	@Test
	void testComponent() {
		LOGGER.debug("Component test");
		Assertions.assertTrue(true);
	}
}
