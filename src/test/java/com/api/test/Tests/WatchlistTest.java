package com.api.test.Tests;

import com.api.test.Utilities.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@DisplayName("Watchlist Endpoint")
public class WatchlistTest extends TestBase {

    @BeforeAll
    public static void authenticate() {
        setupLogin();
    }

    @Test
    @DisplayName("should return empty watchlist with no prior data")
    public void testSize(){
        given().
                spec(authSpec).
                when().
                get("/movies/watchlist/" + userId).
                then().
                assertThat().body("size()", is(0));
    }

    @Test
    @DisplayName("should return a movie that is added to the users watchlist")
    public void testUpdate(){
        String movieId;

        //Retrieve id from first movie in the list
        movieId = given().
                spec(authSpec).
                when().
                get("/movies").
                thenReturn().jsonPath().getString("_id[0]");

        //Add first movie to watchlist
        given().
                spec(authSpec).
                when().
                put("/movies/" + movieId + "/watchlist/" + userId);

        //Confirm watchlist contains 1 movie
        given().
                spec(authSpec).
                when().
                get("/movies/watchlist/" + userId).
                then().
                assertThat().
                body("size()", is(1));
    }
}
