package baseEntities;

import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.BeforeEach;
import services.ReadProperties;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
    public ReadProperties properties;

    @BeforeEach
    public void setUp() {

        properties = new ReadProperties();

        io.restassured.RestAssured.requestSpecification = given()
                .header(HTTP.CONN_KEEP_ALIVE,"timeout=5", "max=1000" )
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
