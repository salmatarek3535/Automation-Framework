package testCases;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class TAU_RestAssured {

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;
    private static final String baseUri = "http://zippopotam.us/";


    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        Object[][] data = {
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
        return data;
    }

    // set request specifications for all the requests in the class
    @BeforeClass
    public static void setRequestSpecification() {
        requestSpecification = new RequestSpecBuilder().
                setBaseUri(baseUri).
                build();
    }

    // set response assertions for all the requests in the class
    @BeforeClass
    public static void setResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void getCountryByCountryCodeAndZipCode() {
        // assert the response code and content type
        given().baseUri(baseUri).
                when().get("us/90210").
                then().assertThat().statusCode(200).contentType(ContentType.JSON);

        // log the request details and the response body to check the api if there is any error
        given().baseUri(baseUri).
                log().all().
                when().get("us/90210").
                then().log().body();

        // assert specific value in the body
        given().baseUri(baseUri).
                when().get("us/90210").
                then().
                assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));

        // assert if the collection of elements in the body contain specific item
        given().baseUri(baseUri).
                when().get("us/90210").
                then().
                assertThat().body("places.state", hasItem("California"));

        // assert if the response body for a collection of elements and check the size of the collection
        given().baseUri(baseUri).
                when().get("us/90210").
                then().
                assertThat().body("places.state", hasSize(1));
    }

    // run the same test case with different data using dataProvider annotations
    @Test(dataProvider = "zipCodesAndPlaces")
    public void getCountryByCountryCodeAndZipCode_usingTestData(String countryCode, String zipCode, String expectedPlaceName) {
        given().
            baseUri(baseUri).
            pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
            get("{countryCode}/{zipCode}").
        then().
            assertThat().body("places[0].'place name'", equalTo(expectedPlaceName));
    }

    // run the same test case with different data using dataProvider annotations and with specified specifications for the requests and the responses
    @Test(dataProvider = "zipCodesAndPlaces")
    public void getCountryByCountryCodeAndZipCode_usingTestDataAndSpecifications(String countryCode, String zipCode, String expectedPlaceName) {
        given().
            spec(requestSpecification).
            pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
            get("{countryCode}/{zipCode}").
        then().
            spec(responseSpecification).
        and().
            assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));
    }

    // extract data from response body and assert on it
    @Test
    public void extractPlaceNameByCountryCodeAndZipCode() {

        String placeName =
        given().
            spec(requestSpecification).
        when().
            get("us/90210").
        then().
            extract().
                path("places[0].'place name'");

        Assert.assertEquals(placeName,"Beverly Hills");

    }

}
