package tests;

import io.qameta.allure.*;
import models.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.sleep;

@Epic("UI WB")
@Feature("Currency")
@Owner("Tim")
public class CurrencyChangeTest extends BaseTest{

    @BeforeEach
    void before() {
        mainPage.openMainPage();
    }

    @ParameterizedTest
    @EnumSource(Currency.class)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Смена валюты")
    void defaultCurrencyTest(Currency currency) {
        mainPage
                .changeCurrency(currency.name())
                .checkCurrency(currency.getSymbol());
    }
}
