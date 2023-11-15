package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EventTest {
    private Event event;

    @BeforeEach
    void setup() {
        event = new Event();
    }

    @DisplayName("크리스마스이벤트 할인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"25,3400", "26,0"})
    void christmasDDay_테스트(int value, int expected) {
        int date = value;

        int actual = event.christmasDDay(date);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("평일할인 이벤트 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,7,4046", "1,8,0"})
    void weekday_테스트(int value1, int value2, int expected) {
        int dessertCount = value1;
        int date = value2;

        int actual = event.weekday(dessertCount, date);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void weekend() {
    }

    @Test
    void starDay() {
    }

    @Test
    void present() {
    }
}