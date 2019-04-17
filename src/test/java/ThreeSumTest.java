import org.hamcrest.CoreMatchers;
import org.junit.Test;
import threesum.ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {
    @Test
    public void should_return_right1() {
        // Given
        int[] arr = {-1, 0, 1, 2, -1, 4};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void should_return_right2() {
        // Given
        int[] arr = {0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then
        assertEquals(1, result.size());
    }

    @Test
    public void should_return_right3() {
        // Given
        int[] arr = {0, 0};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then
        assertEquals(0, result.size());
    }

    @Test
    public void should_return_right4() {
        // Given
        int[] arr = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then
        assertEquals(6, result.size());
    }
    //[-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
    //[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]

    //[-5,1,-3,-1,-4,-2,4,-1,-1]
    //[[-5,1,4],[-3,-1,4]]

    @Test
    public void should_return_right5() {
        // Given
        int[] arr = {-5,1,-3,-1,-4,-2,4,-1,-1};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void should_return_right6() {
        // Given
        int[] arr = {-2,0,0,2,2};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then
        assertEquals(1, result.size());

    }

    @Test
    public void should_return_right7() {
        // Given
        int[] arr = {3,0,-2,1,-1,2};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then

        assertEquals(3, result.size());
    }

    @Test
    public void should_return_right8() {
        // Given
        int[] arr = {-5,1,-3,-1,-4,-2,4,-1,-1};
        ThreeSum threeSum = new ThreeSum();
        // When
        List<List<Integer>> result = threeSum.threeSum(arr);
        // Then

        assertEquals(2, result.size());
    }
}
