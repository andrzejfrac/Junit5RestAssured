import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExampleTest extends BaseTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void homeMethodShouldReturnProperResponse() {
        System.out.println("Running test...");
        Response response = given()
                .port(port)
                .baseUri(baseURI)
                .basePath("/")
                .get();
        assertThat("Should be equal", response.getStatusCode(), is(200));
    }
}
