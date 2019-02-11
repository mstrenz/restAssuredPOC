package com.api.test.Tests;

import com.api.test.Utilities.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.lessThan;

public class EndpointTest extends TestBase {

    @Test
    public void verifySuccess() {
        given().
                spec(requestSpec).
                when().
                get("/").
                then().
                statusCode(200);
    }

    @Test
    public void verifyShape(){
        given().
                spec(requestSpec).
                when().
                get("/").
                then().
                body("field", hasItems("value1", "value2")).
                and().body("field2", hasItems(99, 1));
    }

    @Test
    public void verifyTime(){
        given().
                spec(requestSpec).
                when().
                get("/").
                then().
                time(lessThan(1000L));
    }
}
