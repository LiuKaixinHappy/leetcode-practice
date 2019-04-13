import basiccalculator.BasicCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicCalculatorTest {
    @Test
    public void should_return_2_when_input_1_plus_1() {
        // Given
        String s = "1+1";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(2, result);
    }

    @Test
    public void should_return_12_when_input_1_plus_11() {
        // Given
        String s = "1+11";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(12, result);
    }

    @Test
    public void should_return_3_when_input_2_minus_1_plus_2() {
        // Given
        String s = " 2-1 + 2 ";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(3, result);
    }

    @Test
    public void should_return_2_when_input_1_plus_1_with_empty_space() {
        // Given
        String s = "1 + 1";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(2, result);
    }

    @Test
    public void should_return_4_when_input_1_plus_1_plus_2_with_parentheses() {
        // Given
        String s = "(1 + 1) + 2";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(4, result);
    }

    @Test
    public void should_cal_right_when_input_with_2_pair_of_parentheses() {
        // Given
        String s = "(3-2)-(6-8)";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(3, result);
    }

    @Test
    public void should_cal_right_when_parentheses_is_in_the_mid() {
        // Given
        String s = "1+(1+3)+2";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(7, result);
    }

    @Test
    public void should_cal_right() {
        // Given
        String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
        BasicCalculator calculator = new BasicCalculator();
        // When
        int result = calculator.calculate(s);
        // Then
        assertEquals(-15, result);
    }
}
