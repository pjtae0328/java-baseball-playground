package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void q0() {
        String actual = "1,2";
        String[] result = actual.split(",");
        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");

        actual = "1";
        result = actual.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void q1() {
        String actual = "(1,2)";
        actual = actual.substring(1, actual.length()-1);

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스 charAt 특정문자 인덱스 가져오기")
    void q2() {
        String actual = "abc";

        int findIndex = getIndex(actual, 'a');
        assertThat(findIndex).isEqualTo(0);

        findIndex = getIndex(actual, 'b');
        assertThat(findIndex).isEqualTo(1);

        findIndex = getIndex(actual, 'c');
        assertThat(findIndex).isEqualTo(2);


    }

    @Test
    @DisplayName("String 클래스 charAt string index out of bounds exception 테스트")
    void q3() {
        String actual = "abc";

        assertThatThrownBy(() -> actual.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    private int getIndex(String actual, char target) {
        for (int i=0; i<actual.length(); i++) {
            if(actual.charAt(i) == target) {
                return i;
            }
        }

        return -1;
    }

}
