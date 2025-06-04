package org.example.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.api.ExecutableRequest;
import org.example.api.models.Client;
import org.example.api.models.Token;

import java.util.List;

import static io.restassured.RestAssured.given;


public class PostClient implements ExecutableRequest<List<Client>> {

    private final RequestSpecBuilder requestSpecBuilder;

    public PostClient(Token token, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.addHeader("Authorization", "Bearer " + token.getToken());
        this.requestSpecBuilder.setContentType(ContentType.JSON);
    }

    @Override
    @Step("Post request - List of clients")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("clients");
    }

    @Override
    @Step("Post request - Save as list of clients")
    public List<Client> saveAsDto() {
        return execute().then().statusCode(200).extract().body().jsonPath().getList(".", Client.class);
    }
}
