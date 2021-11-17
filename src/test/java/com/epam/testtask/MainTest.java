package com.epam.testtask;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import baseEntities.BaseAPITest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTest extends BaseAPITest {
    private static final Logger LOGGER = LogManager.getLogger(MainTest.class);

    @ExtendWith(ReportPortalExtension.class)
    @Test
    public void FindPetByIdPositiveTest() {
        LOGGER.info("MainTest");
        String endPoint = "/pet/3";

        Response response = given()
                .when().get(endPoint);

        int statusCode = response.getStatusCode();
        assertThat(statusCode).isEqualTo(200);
    }

    @ExtendWith(ReportPortalExtension.class)
    @Test
    public void FindPetByStatusPositiveTest() {
        String endPoint = "/pet/findByStatus?status=available";

        Response response = given()
                .when().get(endPoint);

        int statusCode = response.getStatusCode();
        assertThat(statusCode).isEqualTo(200);
        String responseBody = response.getBody().asString();
        assertThat(responseBody).contains("available");
    }

    @ExtendWith(ReportPortalExtension.class)
    @Test
    public void CreateUserPositiveTest() {
        String endPoint = "user/createWithList";

        User newUser = User.builder()
                .id(2)
                .username("testUserName")
                .firstName("testFirstName")
                .lastName("testLastName")
                .email("auto_" + RandomStringUtils.randomAlphabetic(5) + "@testmail.com")
                .password(RandomStringUtils.randomAlphabetic(10))
                .phone("+375121234567")
                .userStatus(1)
                .build();

//        JSONObject request = new JSONObject();
//        request.put("id", newUser.getId());
//        request.put("username", newUser.getUsername());
//        request.put("firstName", newUser.getFirstName());
//        request.put("lastName", newUser.getLastName());
//        request.put("email", newUser.getEmail());
//        request.put("password", newUser.getPassword());
//        request.put("phone", newUser.getPhone());
//        request.put("userStatus", newUser.getUserStatus());

        given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .when().post(endPoint)
                .then().statusCode(200);

//        int statusCode = response.getStatusCode();
//        assertThat(statusCode).isEqualTo(200);
    }

}
