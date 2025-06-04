package org.example.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.api.ExecutableRequest;
import org.example.api.models.Token;

import static io.restassured.RestAssured.given;

public class PostCredentials implements ExecutableRequest<Token> {

    private final RequestSpecBuilder requestSpecBuilder;

    public PostCredentials(String username, String userSecret, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.addPathParam("username", username);
        this.requestSpecBuilder.addFormParam("userSecret", userSecret);
    }

    @Override
    @Step("Post request - user credentials")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("jwt/{username}");
    }

    @Override
    @Step("Post request - save token as object")
    public Token saveAsDto() {
        String token = execute().then().statusCode(200).contentType(ContentType.TEXT).extract().asString();
        return new Token(token);
    }


}
