package Practice;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiClass {

    static {
        RestAssured.filters(new LoggingFilter());
    }

    @Test
    public void checkFilter(){
        Response response = RestAssured.given()
                .baseUri("https://reqres.in/")
                .header("Test","Ankit")
                .queryParam("abb","dd")
                .body("testing")
                .get("api/users?page=2");

//        System.out.println("Res status code = "+response.getStatusCode());
        System.out.println("Res = "+response.asString());


    }


}

