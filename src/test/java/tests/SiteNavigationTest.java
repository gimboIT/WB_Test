package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Epic("UI WB")
@Feature("Navigation")
@Owner("Tim")
public class SiteNavigationTest extends BaseTest {

    @BeforeEach
    void before() {
        mainPage
                .openMainPage()
                .openBurgerMenu();
    }

    @ParameterizedTest
    @CsvSource({
            "Женщинам, Блузки и рубашки, Женские блузки и рубашки",
            "Мужчинам, Брюки, Мужские брюки"
    })
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка навигации сайта")
    void categoryTest(String category, String subCategory, String title) {
        mainPage
                .hoverCategory(category)
                .openSubCategory(subCategory);
        foundProductsPage
                .checkTitle(title);
    }

    @ParameterizedTest
    @CsvSource({
            "Спорт, Фитнес и тренажеры, Инвентарь, Спортивный инвентарь для фитнеса",
            "Книги, Художественная литература, Проза, Книги в жанре проза"
    })
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка навигации сайта")
    void categoryTest(String category, String subCategory, String subSubCategory, String title) {
        mainPage
                .hoverCategory(category)
                .openSubCategory(subCategory)
                .openSubCategory(subSubCategory);
        foundProductsPage
                .checkTitle(title);
    }
}
