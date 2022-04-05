package unit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {

    @Test
    void exceptionTest() {

    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 has")
    public void charGetFromString1() {
        String name = "Fortune";
        int index = 10;

        assertThatThrownBy(() -> {
            name.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 with")
    public void charGetFromString2() {
        String name = "Fortune";
        int index = 10;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    name.charAt(index);
                }).withMessageContaining("%d", index);
    }
}
