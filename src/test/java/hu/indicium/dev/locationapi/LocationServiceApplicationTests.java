package hu.indicium.dev.locationapi;

import hu.indicium.dev.locations.LocationServiceApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Application")
@Tag("Application")
class LocationServiceApplicationTests {

    @Test
    @DisplayName("Test context loading")
    void contextLoads() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test startup")
    void main() {
        LocationServiceApplication.main(new String[]{});
        assertThat(true).isTrue();
    }

}
