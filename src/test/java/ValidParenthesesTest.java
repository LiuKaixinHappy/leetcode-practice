import org.junit.Test;
import validparentheses.ValidParentheses;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ValidParenthesesTest {
    @Test
    public void should_return_true_when_parentheses_is_valid() {
        // Given
        ValidParentheses validParentheses = new ValidParentheses();
        // When
        boolean result = validParentheses.isValid("(){}");
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_parentheses_is_invalid() {
        // Given
        ValidParentheses validParentheses = new ValidParentheses();
        // When
        boolean result = validParentheses.isValid("(){");
        // Then
        assertFalse(result);
    }

    @Test
    public void should_return_true_when_parentheses_is_empty() {
        // Given
        ValidParentheses validParentheses = new ValidParentheses();
        // When
        boolean result = validParentheses.isValid("");
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_parentheses_is_start_with_close_brackets() {
        // Given
        ValidParentheses validParentheses = new ValidParentheses();
        // When
        boolean result = validParentheses.isValid(")");
        // Then
        assertFalse(result);
    }
}
