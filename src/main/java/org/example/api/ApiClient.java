package org.example.api;

import io.restassured.builder.RequestSpecBuilder;
import org.example.api.models.Token;
import org.example.api.requests.post.PostClient;
import org.example.api.requests.post.PostCredentials;

import java.util.function.Supplier;

public class ApiClient {

    private final Supplier<RequestSpecBuilder> requestSpecBuilderSupplier;

    public ApiClient(Supplier<RequestSpecBuilder> requestSpecBuilderSupplier) {
        this.requestSpecBuilderSupplier = requestSpecBuilderSupplier;
    }

    public PostCredentials postCredentials(String username, String userSecret) {
        return new PostCredentials(username, userSecret, requestSpecBuilderSupplier.get());
    }

    public PostClient postClient(Token token) {
        return new PostClient(token, requestSpecBuilderSupplier.get());
    }
}
