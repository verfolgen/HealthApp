# Healthapp
The headless application for the accounting and control of medicines (drugs).
The project has the following packages:
- 'registrastion' implements the authorization logic;
- 'drug' is entity for save and service logic;
- 'user' - is entity for save user;
- 'email' the logic of email confirmation (issuing a token to log in to the application);
- 'security' config security app.

Integration testing is organized in the application using Testcontainers and MockMvc.

### Backend
- Spring Boot 
- Liquibase
- PostgreSQL Database
- Mapstruct
- Lombok
- Junit
- Testcontainers
