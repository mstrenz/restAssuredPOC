package com.api.test.Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static RequestSpecBuilder builder;
    public static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://www.mocky.io/v2/5c61f0693000006a00019575";

        builder = new RequestSpecBuilder();
        requestSpec = builder.build();

        //Setting default headers for use in child classes
        requestSpec.accept("application/json");
        requestSpec.contentType("application/json");
    }
}
