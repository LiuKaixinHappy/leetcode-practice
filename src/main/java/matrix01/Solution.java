package matrix01;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = cell[0] + dir[i][0];
                int c = cell[1] + dir[i][1];
                int cur = matrix[cell[0]][cell[1]];
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= cur) {
                    continue;
                }
                q.add(new int[]{r, c});
                matrix[r][c] = cur + 1;
            }
        }
        return matrix;
    }
}
