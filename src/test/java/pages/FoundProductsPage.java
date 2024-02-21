package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FoundProductsPage {

    SelenideElement catalogTitle = $(".catalog-title");

    @Step("Проверяем название категории")
    public void checkTitle(String title) {
        catalogTitle.shouldHave(text(title));
    }
}
