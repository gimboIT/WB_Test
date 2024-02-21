package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement
            navBurger = $(".nav-element__burger"),
            loginButton = $(".j-main-login"),
            currencyButton = $(".profile-menu__link--currency"),
            firstProduct = $("article[data-card-index='0']"),
            firstProductValue = firstProduct.$(".price__lower-price"),
            search = $("#searchInput"),
            addInBasketButton = $(".product-card__add-basket"),
            notificationTextAddInBasket = $(".action-notification__text"),
            basketCounter = $(".navbar-pc__notify"),
            basketButton = $("[data-wba-header-name=\"Cart\"]");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("https://www.wildberries.ru/");
        return this;
    }
    @Step("Открываем категории товаров")
    public void openBurgerMenu() {
        firstProductValue.getText();
        navBurger.click();
    }

    @Step("Наводимся на категорию {categoryName}")
    public MainPage hoverCategory(String categoryName) {
        $(byText(categoryName)).shouldBe(visible).hover();
        return this;
    }
    @Step("Открываем категорию {categoryName}")
    public MainPage openSubCategory(String categoryName) {
        $(byText(categoryName)).click();
        return this;
    }
    @Step("Меняем валюту на {currency}")
    public MainPage changeCurrency(String currency) {
        loginButton.hover();
        currencyButton.click();
        $(byText(currency)).click();
        return this;
    }
    @Step("Проверяем валюту")
    public MainPage checkCurrency(String currencySymbol) {
        firstProduct.shouldHave(text(currencySymbol));
        return this;
    }
    @Step("Ищем в поиске {productName}")
    public MainPage searchProduct(String productName) {
        search.setValue(productName).pressEnter();
        return this;
    }
    @Step("Добавляем товар в корзину")
    public MainPage addInBasket() {
        firstProduct.hover();
        addInBasketButton.click();
        notificationTextAddInBasket.shouldHave(text("Товар добавлен в корзину"));
        return this;
    }
    @Step("Нажимаем на иконку корзины")
    public MainPage enterInBasket() {
        basketButton.click();
        return this;
    }
}
