package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;


public class First extends TestBase {


    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("EN", List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of("RU", List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @Tag("selenide")
    @MethodSource("data")
    @ParameterizedTest
    void test13(String lang, List<String> list) {
        Selenide.open("/");
        $$("#languages a").findBy(Condition.text(lang)).click();
        List<String> elements = $$(".main-menu-pages a").filter(Condition.visible).texts();

        Assertions.assertEquals(list, elements);
    }


}