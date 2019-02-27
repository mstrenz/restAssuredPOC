## GETTING STARTED

* [Java 11 SDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

* Import as new project in [IntelliJ](https://www.jetbrains.com/idea/download) (Optional)
	* Select build.gradle file then choose check auto-import in settings

* Must be running the [fakeflix api](https://bitbucket.org/slalom-consulting/fakeflix-api/src/master/)

## RUNNING TESTS FROM COMMAND LINE

All tests will be run with the main test target.  Other targets can be run to subset of tests (smoke)

```./gradlew test```

To run specific tests/class use the --tests parameter

```./gradlew test --tests=TestClass```

```./gradlew test --tests=*TestMethod```

## REPORTS

Reports are generated and stored in build/reports/tests/{Test Target}/index.html

## DOCS

[Rest Assured](https://github.com/rest-assured/rest-assured/wiki/Usage)

## TEST SCENARIOS

* API
	* assert invalid auth/error code
	* login with valid auth in header
	* assert timing of response
	* post with valid payload
	* setup, manipulate, and assert data roundtrip