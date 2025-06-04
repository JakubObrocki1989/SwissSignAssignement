package org.example.api.models.Product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductValidity {
    @JsonProperty("validityType")
    private String validityType;
    @JsonProperty("validity")
    private int validity;
    @JsonProperty("validityOptions")
    private List<String> validityOptions;
}

