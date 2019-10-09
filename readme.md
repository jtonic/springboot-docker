# Objectives

- [x] Build and run a spring application in a docker container

    - [x] documentation about sb application in docker
        - [here](https://spring.io/guides/gs/spring-boot-docker/)
        - [here](https://spring.io/guides/topicals/spring-boot-docker)
    - [x] jdk -> [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/docker-install.html)
    - [x] jre 
        -> [Azul jre-11 alpine docker hub](https://hub.docker.com/r/azul/zulu-openjdk-alpine/tags)
        -> [Azul jre/jdk home page](https://www.azul.com/downloads/zulu-community/)

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
        
        > **Note:** As a piece of advice consider making a small image.
        >
        > The image size can be queried with the following command:
        > 
        >  `docker images jtonic/springboot-docker:v1  --format "{{.Repository}}:{{.Tag}} {{.Size}}"`
        > 
        > with zool jre 11
        >  docker images springboot-docker-zool-jre  --format "{{.Repository}}:{{.Tag}} {{.Size}}"
        >  springboot-docker-zool-jre:latest **151MB**
        > 
        > with amazon corretto jdk 11
        > docker images jtonic/springboot-docker:v1  --format "{{.Repository}}:{{.Tag}} {{.Size}}"                                                                     master ✱
        > jtonic/springboot-docker:v1 **514MB**
        > 
        > As you can see there is a huge difference 151 MB -> 514 MB
    
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
