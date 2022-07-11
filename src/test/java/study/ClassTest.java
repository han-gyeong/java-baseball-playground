package study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ClassTest {

    @Test
    void classTest() {

        // 성공
        Exception exception = new IndexOutOfBoundsException();
        assertThat(Exception.class).isAssignableFrom(IndexOutOfBoundsException.class);

        // 실패
//        IndexOutOfBoundsException indexOutOfBoundsException = new Exception();
//        assertThat(IndexOutOfBoundsException.class).isAssignableFrom(Exception.class);

        assertThat(Test.class).isAnnotation();

        assertThat(List.class).isInterface();
    }
}
