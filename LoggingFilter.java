package Practice;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification,
                           FilterContext filterContext) {
        getRequestData(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        System.out.println("----------");
        getResponseData(response);
        return  response;
    }

    public void getRequestData(FilterableRequestSpecification requestSpecification){
        System.out.println("base URI = "+requestSpecification.getBaseUri());
        System.out.println("Header = "+requestSpecification.getHeaders());
        System.out.println("Body = "+requestSpecification.getBody());
        System.out.println("Query Param = "+requestSpecification.getQueryParams());
    }

    public void getResponseData(Response response){
        System.out.println("status code = "+response.getStatusCode());
        System.out.println("Header = "+response.getHeaders());
        System.out.println("Body = "+response.getBody().asString());

    }

}
