
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
    public void mainPage() {
        open("/");
    }

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
    public void bannerBlockIsVisible() {
        $(".jss1").shouldBe(visible);
        $(".btn.btn_white.m-auto.styles_btn__3EXuK").shouldBe(visible);

    }

    @Test
    public void categoriesText() {
//        $$(".styles_h2__Yn_NB.styles_titleLink__1JtNm").shouldHave(size(4));
        $$(".styles_h2__Yn_NB.styles_titleLink__1JtNm").get(0).shouldHave(text("MARBLE SLAB"));
        $$(".styles_h2__Yn_NB.styles_titleLink__1JtNm").get(1).shouldHave(text("GREAT AMERICAN COOKIES"));
        $$(".styles_h2__Yn_NB.styles_titleLink__1JtNm").get(2).shouldHave(text("CAKES"));
        $$(".styles_h2__Yn_NB.styles_titleLink__1JtNm").get(3).shouldHave(text("EVENTS AND PARTIES"));
    }

    @Test
    public void buttonOrderNowIsVisible() {
        $(".btn_white.styles_orderNowBtn__2qWQ3").shouldBe(visible);
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
        $(".MuiBox-root.jss21").shouldBe(visible).shouldHave(
                text("©Copyright 2021. All rights reserved."),
                text("Terms and Conditions")
        );
    }

    @Test
    public void clickOnLogInButton() {
        $(".styles_header_btn__2ESOZ.styles_mr_20__30uV6").click();
        $(byText("Don’t have an account? Register Now")).shouldBe(visible);

    }

}