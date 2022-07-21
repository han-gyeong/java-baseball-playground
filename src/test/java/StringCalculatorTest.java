import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void 더하기_연산() {
        String answer = StringCalculator.calculate("2 + 3");
        assertThat(answer).isEqualTo("5");
    }

    @Test
    void 빼기_연산() {
        String answer = StringCalculator.calculate("3 - 2");
        assertThat(answer).isEqualTo("1");
    }

    @Test
    void 곱하기_연산() {
        String answer = StringCalculator.calculate("2 * 3");
        assertThat(answer).isEqualTo("6");
    }

    @Test
    void 나누기_연산() {
        String answer = StringCalculator.calculate("100 / 2");
        assertThat(answer).isEqualTo("50");
    }

    @Test
    void 음수_연산() {
        String answer = StringCalculator.calculate("-1 * 2 + 2");
        assertThat(answer).isEqualTo("0");
    }

    @Test
    void 복잡한_연산() {
        String answer = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(answer).isEqualTo("10");
    }
}