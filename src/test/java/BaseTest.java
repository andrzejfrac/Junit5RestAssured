import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

public class BaseTest {
    private static String testPropertiesFile = "src/test/resources/test.properties";
    private static Properties testProperties;

    @BeforeAll
    public static void setUpAll() throws Exception {
        loadTestProperties();
        baseURI = testProperties.getProperty("baseUri");
        port = Integer.valueOf(testProperties.getProperty("server.port"));
        System.out.println("The url set in BaseTest is: " + baseURI + " and the port is: " + port);
    }

    private static void loadTestProperties() throws IOException {
        testProperties = new Properties();
        testProperties.load(new FileInputStream(new File(testPropertiesFile)));
    }
}