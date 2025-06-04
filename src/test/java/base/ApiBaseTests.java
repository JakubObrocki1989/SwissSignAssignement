package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.api.ApiClient;
import org.example.api.handlers.TokenHandler;


public class ApiBaseTests extends BaseTests {


    protected TokenHandler tokenHandler = new TokenHandler();

    protected ApiClient createApiClient() {
        return new ApiClient(() -> new RequestSpecBuilder()
                .setContentType(ContentType.URLENC)
                .addFilter(new AllureRestAssured())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setBaseUri(properties.getProperty("apiBaseUrl")));
    }


}
