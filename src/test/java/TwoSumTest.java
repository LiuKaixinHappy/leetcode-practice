import org.junit.Test;
import twosum.TwoSum;

import static org.junit.Assert.assertEquals;

public class TwoSumTest {
    @Test
    public void test_two_sum() {
        // Given
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        // When
        TwoSum result = new TwoSum();
        int[] indices = result.twoSum(nums, target);
        // Then
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], indices[i]);
        }
    }
}
