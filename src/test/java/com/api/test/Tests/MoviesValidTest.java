package com.api.test.Tests;

import com.api.test.Utilities.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

@DisplayName("Movies Endpoint with Valid Auth")
public class MoviesValidTest extends TestBase {

    @BeforeAll
    public static void authenticate() {
        setupLogin();
    }

    @Test
    @DisplayName("should return a 200 status code")
    public void TestValidAuth() {
        given().
                spec(authSpec).
                when().
                get("/movies").
                then().
                statusCode(200);
    }

    @Test
    @DisplayName("should return in under 1 second")
    public void testTimeout() {
        given().
                spec(authSpec).
                when().
                get("/movies").
                then().
                time(lessThan(1000L));
    }
}
