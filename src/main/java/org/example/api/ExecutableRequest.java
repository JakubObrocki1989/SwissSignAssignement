package org.example.api;

import io.restassured.response.Response;

public interface ExecutableRequest<T> {

    Response execute();

    T saveAsDto();
}
