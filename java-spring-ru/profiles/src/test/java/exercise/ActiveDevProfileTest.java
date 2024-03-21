package exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles(value = "development")
public class ActiveDevProfileTest {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Test
    void testProperties() {
        assertThat(dataSourceUrl).isEqualTo("jdbc:h2:mem:test");
        assertThat(dataSourceUsername).isEqualTo("sa");
        assertThat(dataSourcePassword).isEqualTo("123");
    }
}
