
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPageTest {

    @BeforeClass
    public static void setUp() {
        closeWebDriver();
        Configuration.baseUrl = "https://app.zad-cakes-dev.php-cd.attractgroup.com";
        Configuration.browserSize = "1980x1000";
//        Configuration.startMaximized = true;
    }

    @Before
    public void logInPage() {
        open("/sign-in");
    }

    //============== design ==================

    @Test
    public void logoIsVisible() {
        $("img.style_logo__3cYXc").shouldBe(visible);
    }

    @Test
    public void headerElementsIsVisible() {
        $$(".styles_header_btn__2ESOZ").get(0).shouldBe(visible);
        $$(".styles_header_btn__2ESOZ").get(1).shouldBe(visible);
        $(".styles_header_block__3Ci3M.styles_cart__OKkOy").shouldBe(visible);
        $(".styles_header_block__3Ci3M.styles_lang__3FOzf").shouldBe(visible);
    }

    @Test
    public void sideMenuText() {
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(0).shouldHave(text("Order Now"));
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(1).shouldHave(text("What’S New"));
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(2).shouldHave(text("Locations"));
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(3).shouldHave(text("Contact Us"));
    }

    @Test
    public void footerText() {
        $(".copyright").shouldBe(visible).shouldHave(
                text("©Copyright 2021. All rights reserved.\n" +
                        "Privacy Policy")
//                text("Privacy policy")
//                text("Terms and Conditions")
        );
    }

    //--------------------------------------------------

    @Test
    public void informText() {
        $(".jss1").shouldHave(
                text("Don’t have an account? Register Now"));
    }

    @Test
    public void emailFieldIsVisible() {
        $(".jss2").shouldBe(visible);
    }

    @Test
    public void passwordFieldIsVisible() {
        $(".jss3").shouldBe(visible);
    }

    @Test
    public void checkboxVisible() {
        $("span.MuiButtonBase-root > span:nth-child(2)").shouldBe(visible);
    }

    @Test
    public void checkboxText() {
        $(".MuiTypography-body1").shouldHave(text("Remember me"));
    }

    @Test
    public void checkboxIsChecked() {
        $(".MuiCheckbox-root").click();
        $(".Mui-checked").shouldBe(visible);
    }

    @Test
    public void forgotLinkText() {
        $("div.MuiGrid-root:nth-child(2) > a:nth-child(1)").shouldHave(text("Forgot password?"));
    }

    @Test
    public void clickOnForgotLink() {
        $("div.MuiGrid-root:nth-child(2) > a:nth-child(1)").click();
        $(".styles_h1__1e8I0").shouldHave(text("Forgot password"));
    }

    @Test
    public void buttonLogInIsVisible() {
        $(".MuiButton-contained").shouldBe(visible);
    }

    @Test
    public void buttonLogInWithGoogleIsVisible() {
        $$(".styles_btnSocial__3_Jx6").get(0).shouldBe(visible);
    }

    @Test
    public void buttonLogInWithInstagramIsVisible() {
        $$(".styles_btnSocial__3_Jx6").get(1).shouldBe(visible);
    }

    //============= functionality ================

    @Test
    public void messageForEmptyEmailField() {
        $(By.name("password")).val("Qwer1234-");
        $(".MuiButton-contained").click();
        $(".MuiFormHelperText-root").shouldHave(text("email is a required field"));
    }

    @Test
    public void messageForEmptyEmailAndPasswordField() {
        $(".MuiButton-contained").click();
        $$(".MuiFormHelperText-root").get(0).shouldHave(text("email is a required field"));
        $$(".MuiFormHelperText-root").get(1).shouldHave(text("password is a required field"));
    }

    @Test
    public void messageForIncorrectEmail() {
        $(By.name("email")).val("vvv111000999");
//        $(By.name("password")).val("Qwer1234-");
        $(".MuiButton-contained").click();
        $(".MuiFormHelperText-root").shouldHave(text("email must be a valid email"));
    }

    @Test
    public void messageForUnregisteredEmail() {
        $(By.name("email")).val("vvv111000999@gmail.com");
        $(By.name("password")).val("Qwer1234-");
        $(".MuiButton-contained").click();
        $(".MuiFormHelperText-root").shouldHave(text("Oops, this email is not registered with Zad-Cakes."));
    }

    @Test
    public void messageForIncorrectPassword() {
        $(By.name("email")).val("vihard.test+us3@gmail.com");
        $(By.name("password")).val("Qwer1");
        $(".MuiButton-contained").click();
        $(".MuiFormHelperText-root").shouldHave(text("password must be at least 8 characters"));
    }

    @Test
    public void messageForUnregisteredPassword() {
        $(By.name("email")).val("vihard.test+us3@gmail.com");
        $(By.name("password")).val("Qwer1234----");
        $(".MuiButton-contained").click();
        $(".error-text").shouldHave(text("The entered password is not correct, please try again"));
    }

    @Test
    public void correctAutorisationWithoutCheckbox() {
        $(By.name("email")).val("vihard.test+us3@gmail.com");
        $(By.name("password")).val("Qwer1234-");
        $(".MuiButton-contained").click();
        $("h1").shouldHave(text("Profile"));
        $("button.MuiButtonBase-root:nth-child(2)").click();
    }



}
