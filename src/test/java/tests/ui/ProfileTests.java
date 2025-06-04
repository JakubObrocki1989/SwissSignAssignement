package tests.ui;

import base.UiBaseTests;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ProfileTests extends UiBaseTests {


    @Test
    public void test001_UserShouldBeAbleToChangeCorrespondingLanguage() {
        navbarPage
                .clickLoginButton()
                .typeEmail("jakub.obrocki@gmail.com")
                .clickSubmit()
                .typePassword("P@ss_w0rd#123")
                .clickSubmitButton();
        String currentCorrespondingLanguage = navbarPage
                .clickProfileButton()
                .clickMyProfileButton()
                .getUserCorrespondanceLanguage();
        String newCorrespondingLanguage = profilePage
                .clickEditUserInfoButton()
                .selectLanguage("Deutsch")
                .getUserCorrespondanceLanguage();
        Assert.assertNotEquals("Current corresponding language was: + " + currentCorrespondingLanguage + "but new should be: + " + newCorrespondingLanguage,
                currentCorrespondingLanguage, newCorrespondingLanguage);
        Assert.assertEquals("New corresponding language should be English but was: " + newCorrespondingLanguage, "Deutsch", newCorrespondingLanguage);
    }
}
