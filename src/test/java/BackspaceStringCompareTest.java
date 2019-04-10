import backspacestringcompare.BackspaceStringCompare;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BackspaceStringCompareTest {
    @Test
    public void should_return_true_when_S_and_T_are_same_and_have_same_length() {
        // Given
        String S = "ab##";
        String T = "c#d#";
        BackspaceStringCompare compare = new BackspaceStringCompare();
        // When
        boolean result = compare.backspaceCompare(S, T);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_true_when_S_and_T_are_same_and_have_diff_length() {
        // Given
        String S = "ab#";
        String T = "a";
        BackspaceStringCompare compare = new BackspaceStringCompare();
        // When
        boolean result = compare.backspaceCompare(S, T);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_S_and_T_are_not_same() {
        // Given
        String S = "ab#";
        String T = "#db#";
        BackspaceStringCompare compare = new BackspaceStringCompare();
        // When
        boolean result = compare.backspaceCompare(S, T);
        // Then
        assertFalse(result);
    }

    @Test
    public void should_return_true_when_S_and_T_are_empty() {
        // Given
        String S = "";
        String T = "";
        BackspaceStringCompare compare = new BackspaceStringCompare();
        // When
        boolean result = compare.backspaceCompare(S, T);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_S_and_T_are_diff() {
        // Given
        String S = "bxj##tw";
        String T = "bxj###tw";
        BackspaceStringCompare compare = new BackspaceStringCompare();
        // When
        boolean result = compare.backspaceCompare(S, T);
        // Then
        assertFalse(result);
    }


    @Test
    public void should_return_true_when_S_and_T_are_same() {
        // Given
        String S = "y#fo##f";
        String T = "y#fx#o##f";
        BackspaceStringCompare compare = new BackspaceStringCompare();
        // When
        boolean result = compare.backspaceCompare(S, T);
        // Then
        assertTrue(result);
    }
}
