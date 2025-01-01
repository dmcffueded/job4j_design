package ru.job4j.iterator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ArrayItTest {

    @Test
    void whenMultiCallHasNextThenTrue() {
        ru.job4j.iterator.ArrayIt iterator = new ru.job4j.iterator.ArrayIt(
                new int[] {1, 2, 3}
        );
        boolean result = iterator.hasNext();
        assertThat(result).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenReadSequence() {
        ru.job4j.iterator.ArrayIt iterator = new ru.job4j.iterator.ArrayIt(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }
}