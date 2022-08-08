package ru.netology.web;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.nio.channels.SocketChannel.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class FormCardTest {

    @BeforeEach
    void open() {
        Selenide.open("http://localhost:9999/");

    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void testFormCartDelivery() {
        $("[data-test-id=city] input").setValue("Краснодар");
        $("[data-test-id=date] .input__control").setValue(generateDate(11));
        $("[data-test-id=name] .input__control").setValue("Денисов Николай");
        $("[data-test-id=phone] .input__control").setValue("+79894539835");
        $("[data-test-id=agreement]").click();
        $x("//button[contains(@class, 'button_view_extra')]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        //$("[data-test-id=notification]").shouldHave(exactText("Успешно!"+"Встреча успешно забронирована на " + generateDate(11)));
        $(byText("Успешно!Встреча успешно забронирована на 11.08.2022"));
    }

}







       // [class='notification__title'] [class='notification__content']

