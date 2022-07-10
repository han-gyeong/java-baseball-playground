package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split 작동 확인")
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    @DisplayName("substring 작동 확인")
    void substring() {
        String value = "(1,2)";
        String substring = value.substring(1, value.length() - 1);

        assertThat(substring).isEqualTo("1,2");

        String[] values = substring.split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("charAt 작동 확인")
    void characterAt() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatThrownBy(() -> {
            value.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(5);
                });
    }

    @Test
    void exceptions() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw new IllegalArgumentException("잘못된 인자입니다.");
                });

        assertThatIOException()
                .isThrownBy(() -> {
                    throw new IOException("IO Exception");
                }).withMessage("IO Exception");

        assertThatNullPointerException()
                .isThrownBy(() -> {
                    throw new NullPointerException("NULL POINTER");
                }).withMessageStartingWith("NULL")
                .withMessageContaining("POINT")
                .withMessageEndingWith("POINTER");
    }
}
