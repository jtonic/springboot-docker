# Objectives

- [ ] Build and run a spring application in a docker container

    - [ ] jvm -> [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/docker-install.html)
    - [ ] documentation about sb application in docker
        - [here](https://spring.io/guides/gs/spring-boot-docker/)
        - [here](https://spring.io/guides/topicals/spring-boot-docker)

    - How to build/run/test/publish the application?
    
        - build the application 
        `mvn package`

        - build the maven image
        `docker build -t springboot-docker .`

        - start the container and run the application
        `docker run -d -p 8080:8080 --name springboot-docker springboot-docker`

        - test the docker container is running
        `docker ps`

        - test the application
        `curl http://localhost:8080`
        
        - stop the container
        `docker container stop springboot-docker`

        - remove the container
        `docker container rm springboot-docker`
       
        - check if it was successfully removed
        `docker container ps -a | grep -i springboot-docker --color=always`
        
        - publish the image
        ```bash
        docker login
        # publish latest version
        docker tag springboot-docker jtonic/springboot-docker
        docker push jtonic/springboot-docker
        # latest version taged as v1
        docker tag springboot-docker jtonic/springboot-docker:v1
        docker push jtonic/springboot-docker:v1
        ```
        
        - remove the tagged images
        ```bash
        docker image rm springboot-docker
        docker image rm jtonic/springboot-docker
        docker image rm jtonic/springboot-docker:v1
        ``` 
        
        - removed unused images
        `docker image prune`
        
        - run the remote docker image (for production it is mandatory to run a version)
        `docker run -d -p 8080:8080 --name springboot-docker jtonic/springboot-docker:v1`
        
        - test the application again (see above)
    
- [x] incremental migration from junit4 to junit5 (kotlin project included)
- [x] junit tests with custom logger level
- [x] spring boot 2 with custom logger level
    - The log level can be changed per springboot test class with 
    ```java
    @SpringBootTest(properties = {"logging.level.${logger}=ERROR"})
    @ExtendWith(SpringExtension.class)
    @ComponentTag
    class SpringbootDockerApplicationTests {  }  
    ```
- [x] (simple) use MapStruct for object mapping (for advanced usage see baeldung tutorials below):
    - See why:
        - [performance comparison](https://www.baeldung.com/java-performance-mapping-frameworks
)
        - [Using multiple source usage, update the target](https://www.baeldung.com/mapstruct-multiple-source-objects) 
        - works perfectly with Lombok
        - its not based on reflection
        - allows multiple sources
        - allows target update
        - easy integration with CDI (spring)
    - [Quick guide](https://www.baeldung.com/mapstruct)
    - [Official documentation](https://mapstruct.org/documentation/stable/reference/html/#introduction)
    - [Simple example with mapstruct/lombok/docker](https://hellokoding.com/mapping-jpa-hibernate-entity-and-dto-with-mapstruct/)
    
- [ ] inheritable ThreadLocal when a new child thread is created from http servlet request thread. 
