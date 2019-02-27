package com.api.test.Tests;

import com.api.test.Utilities.TestBase;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Ratings Endpoint")
public class RatingsTest extends TestBase {

    @BeforeAll()
    public static void authenticate(){
        setupLogin();
    }

    //Skipping due to timeout on post
    @Disabled
    @Test
    @DisplayName("accepts a post with a valid payload")
    public void testPost(){
        //Create payload to post
        JSONObject payload = new JSONObject();
        payload.put("id", "test");
        payload.put("rating", 123);

        given().
                spec(authSpec).
                body(payload.toString()).
                post("/movies/ratings").
                then().
                statusCode(200);
    }
}
