package com.api.test.Tests;

import com.api.test.Utilities.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Movies Endpoint with Invalid Auth")
public class MoviesInvalidTest extends TestBase {

    @Test
    @DisplayName("should return a 401 status code")
    public void test401Response(){
        given().
            spec(basicSpec).
        when().
            get("/movies").
        then().
            statusCode(401);
    }
}
