package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    void contains() {
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
        // value 안에 반복적으로 들어가면서 테스트
    void hasValue_withValueSource(int value) {
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void hasValue_dependOnNumberAndExpected(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
