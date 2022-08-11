package base;

import org.assertj.core.internal.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.example.v1.drug.MainApplication;
import org.example.v1.drug.repository.DrugRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = MainApplication.class)
@Testcontainers
public abstract class AbstractIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    @Container
    protected static PostgreSQLContainer container =
            new PostgreSQLContainer<>("postgres:14.4")
                    .withUsername("postgres")
                    .withPassword("ghtq345")
                    .withDatabaseName("druglist");

    protected MockMvc mockMvc;

    static {
        container.start();
    }

    @BeforeEach
    public  void setUpMockMvc() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

}
