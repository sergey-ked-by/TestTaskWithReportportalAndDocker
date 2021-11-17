package baseEntities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
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

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(properties.getURL())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.ANY)
                .log(LogDetail.ALL)
                .build();
        RestAssured.requestSpecification = requestSpec;

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
        RestAssured.responseSpecification = responseSpec;
    }
}
