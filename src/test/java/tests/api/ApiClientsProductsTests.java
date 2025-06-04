package tests.api;

import base.ApiBaseTests;
import org.example.api.ApiClient;
import org.example.api.models.Client;
import org.example.api.models.Token;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ApiClientsProductsTests extends ApiBaseTests {
    private ApiClient api;
    private Token token;

    @BeforeEach
    public void setup() {
        api = createApiClient();
        token = tokenHandler.getToken(api, "SWSTestUser", "K31KRm6vvHYHIFCBZQBoTJARzsaubpZervGV9XeqiSQZ0Fcc9K4zkRhwjDgeo9AU");
    }

    @Test
    public void test001_userShouldObtainAuthToken() {
        token = tokenHandler.getToken(api, "SWSTestUser", "K31KRm6vvHYHIFCBZQBoTJARzsaubpZervGV9XeqiSQZ0Fcc9K4zkRhwjDgeo9AU");
    }

    @Test
    public void test002_userShouldObtainClientsProductsAndCountThem() {
        List<Client> client = api.postClient(token).saveAsDto();
        Assert.assertTrue("Client should have 4 products, but have " + client.get(0).getProducts().size(), client.get(0).getProducts().size() == 4);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    public void test003_parametrizedVersionOfTest002(String username, String userSecret) {
        token = tokenHandler.getToken(api, username, userSecret);
        List<Client> client = api.postClient(token).saveAsDto();
        Assert.assertTrue("Client should have 4 products, but have " + client.get(0).getProducts().size(), client.get(0).getProducts().size() == 4);
    }
}
