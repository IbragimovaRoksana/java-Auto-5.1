package ru.notology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.DataGenerator;
import ru.netology.web.User;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryOrderTest {

    @BeforeAll
    static void setUp() {
        Configuration.headless = true;
    }

    @Test
    void shouldRegisterCardOrder() {
        open("http://localhost:9999");
        User userOne = DataGenerator.Registration.registrationUser();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        $("[data-test-id=city] .input__control").setValue(userOne.getCity());
        $("[data-test-id=date] .input__control[value]").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        $("[data-test-id=date] .input__control").setValue(userOne.getLocalDate());
        $("[data-test-id=name] .input__control").setValue(userOne.getName());
        $("[data-test-id=phone] .input__control").setValue(userOne.getPhone());
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".button .button__text").click();
        //нажимаем продолжить с теми же данными
        $(".button .button__text").click();
        $$(".button .button__text").find(exactText("Перепланировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(6));
    }

}
