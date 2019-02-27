package com.api.test.Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static RequestSpecBuilder builder;
    public static RequestSpecification basicSpec;
    public static RequestSpecification authSpec;
    public static String token;
    public static String userId;
    private static String username;
    private static String secret;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:9000";
        builder = new RequestSpecBuilder();

        //Setting default headers for use in child classes
        basicSpec = builder.build();
        basicSpec.accept("application/json");
        basicSpec.contentType("application/json");

        //Setting auth headers for authentication
        authSpec = builder.build();
        authSpec.accept("application/json");
        authSpec.contentType("application/json");
    }

    public static void setupLogin() {
        JSONObject auth = new JSONObject();

        //Generate random username and secret
        username = RandomStringUtils.randomAlphanumeric(10);
        secret = RandomStringUtils.randomAlphanumeric(20);

        //Build payload for auth
        auth.put("userName", username);
        auth.put("secret", secret);
        auth.put("fullName", "Test User");

        //Register user
        userId = given().spec(basicSpec).
                body(auth.toString()).
                post("/user/register").andReturn().jsonPath().get("_id");

        //Login User
        token = given().spec(basicSpec).
                body(auth.toString()).
                post("/user/login").andReturn().jsonPath().get("token");

        //Add token to spec
        authSpec.header("Authorization", token);
    }
}
