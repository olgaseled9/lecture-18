#  Home task #18
1. Git repo (Done)
2. README.MD file with the task and description. gitignore (Done)
3. create new maven project with 3 modules (Done)
   3.1 entity module (Done)
   3.2 persistence module (Done)
   3.3 (optinal) integration test module 
   3.4 naming: {project-name}-persistence. examples: school-journal-persistence, car-service-entity, etc (Done)
4. Create POJO classes (Done)
5. Use at least 4 class level annotations (for example embedded, immutable, and so on) 
 (@Embedded- UserInformation.class, @Immutable - Status.class )
6. Use at least 5 field level annotations (for example, transient) (@Transient - User.class (password))
7. Use at least 2 diff id generation strategy (Done)
8. create your custom id generation strategy and use it(Done)
9. create your custom name strategy and use it (CustomPhysicalNamingStrategy.class)

#Technologies
Java version: 11
Postgres database
docker-compose
Flyway
Hibernate
Slf4j+logback
Lombok

How to used:

1. Build project: $mvn clean install
2. $docker-compose up -d
3. mvn flyway:migrate
4. Run Runner.class

