
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class LoginPage {

    @BeforeClass
    public static void setUp() {
        closeWebDriver();
        Configuration.baseUrl = "https://app.zad-cakes-dev.php-cd.attractgroup.com";
//        Configuration.browserSize = "1980x1000";
        Configuration.startMaximized = true;
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
        $(".styles_header_btn__2ESOZ.styles_mr_20__30uV6").shouldBe(visible);
        $(".styles_header_btn__2ESOZ").shouldBe(visible);
        $(".styles_header_block__3Ci3M.styles_cart__OKkOy").shouldBe(visible);
        $(".styles_header_block__3Ci3M.styles_lang__3FOzf").shouldBe(visible);
    }

    @Test
    public void sideMenuText() {
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(0).shouldHave(text("Order Now"));
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(1).shouldHave(text("What’s New"));
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(2).shouldHave(text("Locations"));
        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(3).shouldHave(text("Contact Us"));
    }

    @Test
    public void footerText() {
        $(".copyright").shouldBe(visible).shouldHave(
                text("©Copyright 2021. All rights reserved."),
                text("Privacy policy")
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

    //=============

//    @Test
//    public void sideMenuText() {
//        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(0).shouldHave(text("Order Now"));
//        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(1).shouldHave(text("What’s New"));
//        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(2).shouldHave(text("Locations"));
//        $$(".MuiListItem-root.style_itemLeaf__1ZE09.style_sidebarLinks__2bMOA").get(3).shouldHave(text("Contact Us"));
//    }
//
//    @Test
//    public void footerText() {
//        $(".MuiBox-root.jss21").shouldBe(visible).shouldHave(
//                text("©Copyright 2021. All rights reserved."),
//                text("Terms and Conditions")
//        );
//    }
//
//    @Test
//    public void clickOnLogInButton() {
//        $(".styles_header_btn__2ESOZ.styles_mr_20__30uV6").click();
//        $(byText("Don’t have an account? Register Now")).shouldBe(visible);
//
//    }

}
