import matrix01.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Matrix01Test {
    @Test
    public void should_return_right() {
        int[][] origin = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Solution solution = new Solution();
        int[][] res = solution.updateMatrix(origin);
        int[][] expected = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expected[i][j], res[i][j]);
            }
        }
    }

}
