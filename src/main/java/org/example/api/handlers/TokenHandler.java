package org.example.api.handlers;

import org.example.api.ApiClient;
import org.example.api.models.Token;

public class TokenHandler {
    private ApiClient api;
    private Token token;

    public Token getToken(ApiClient api, String username, String userSecret) {
        return api.postCredentials(username, userSecret).saveAsDto();
    }


}
