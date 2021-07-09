
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

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
        $$(".styles_header_btn__2ESOZ").get(0).shouldBe(visible);
        $$(".styles_header_btn__2ESOZ").get(1).shouldBe(visible);
        $(".styles_header_block__3Ci3M.styles_cart__OKkOy").shouldBe(visible);
        $(".styles_header_block__3Ci3M.styles_lang__3FOzf").shouldBe(visible);
    }

    @Test
    public void bannerBlockIsVisible() {
        $(".jss1").shouldBe(visible);
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
    public void pageImages() {
        $$("img").shouldHave(size(5));
    }

    @Test
    public void buttonOrderNowIsVisible() {
        $(".btn_white.styles_orderNowBtn__2qWQ3").shouldBe(visible);
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
        $(".MuiBox-root.jss21").shouldBe(visible).shouldHave(
                text("©Copyright 2021. All rights reserved. Privacy policy")
//                text("Privacy policy")
//                text("Terms and Conditions")
        );
    }

    @Test
    public void clickOnLogInButton() {
        $$(".styles_header_btn__2ESOZ").get(0).click();
        $(byText("LOG IN")).shouldBe(visible);
    }

    @Test
    public void clickOnRegisterButton() {
        $(byText("Register")).click();
        $(byText("REGISTER")).shouldBe(visible);

    }

    @Test
    public void clickOnMirableSlabLink() {
        $(byText("Marble Slab")).click();
        $(byText("Marble Slab")).shouldBe(visible);
    }

    @Test
    public void clickOnGreatAmericanCookiesLink() {
        $(byText("Great American Cookies")).click();
        $(byText("Great American Cookies")).shouldBe(visible);
    }

    @Test
    public void clickOnCakesLink() {
        $(byText("Cakes")).click();
        $(byText("Cakes")).shouldBe(visible);
    }

    @Test
    public void clickOnEventsAndPartiesLink() {
        $(byText("Events and Parties")).click();
        $(byText("Events and Parties")).shouldBe(visible);
    }

    @Test
    public void clickOnOrderNowButton() {
        $(".btn_white.styles_orderNowBtn__2qWQ3").click();
        $(byText("Events and Parties")).shouldBe(visible);
    }
}
