package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void whenParseEmptyArrayThenThrowIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        // Проверяем, что при вызове parse с пустым массивом выбрасывается исключение
        assertThatThrownBy(() -> nameLoad.parse())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Names array is empty");
    }

    @Test
    void whenParseInvalidFormatWithoutEqualsThenThrowIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        // Проверяем, что если строка не содержит символ "=" (например, "key:value")
        assertThatThrownBy(() -> nameLoad.parse("key:value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this name: key:value does not contain the symbol '='");
    }

    @Test
    void whenParseInvalidFormatStartsWithEqualsThenThrowIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        // Проверяем, что если строка начинается с "=", выбрасывается исключение
        assertThatThrownBy(() -> nameLoad.parse("=value"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this name: =value does not contain a key");
    }

    @Test
    void whenParseInvalidFormatEndsWithEqualsThenThrowIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        // Проверяем, что если строка заканчивается на "=", выбрасывается исключение
        assertThatThrownBy(() -> nameLoad.parse("key="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this name: key= does not contain a value");
    }

    @Test
    void whenParseValidDataThenGetMapWithCorrectValues() {
        NameLoad nameLoad = new NameLoad();
        // Проверяем, что правильные данные добавляются в карту
        nameLoad.parse("key1=value1", "key2=value2");
        assertThat(nameLoad.getMap())
                .containsEntry("key1", "value1")
                .containsEntry("key2", "value2");
    }

}