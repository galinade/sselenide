package ru.netology.web;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static java.nio.channels.SocketChannel.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

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



    }




}
