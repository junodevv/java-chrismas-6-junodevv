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

    @Test
    void weekday() {
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