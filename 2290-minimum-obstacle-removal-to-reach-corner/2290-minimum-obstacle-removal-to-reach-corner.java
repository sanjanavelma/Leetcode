import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int[][] diffs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] distance = new int[nRows][nCols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        deque.offerFirst(new int[]{0, 0});
        distance[0][0] = 0;
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int i = current[0], j = current[1];
            for (int[] diff : diffs) {
                int newI = i + diff[0];
                int newJ = j + diff[1];
                if (newI >= 0 && newI < nRows && newJ >= 0 && newJ < nCols) {
                    int newDistance = distance[i][j] + grid[newI][newJ];
                    if (newDistance < distance[newI][newJ]) {
                        distance[newI][newJ] = newDistance;
                        if (grid[newI][newJ] == 0) {
                            deque.offerFirst(new int[]{newI, newJ});
                        } else {
                            deque.offerLast(new int[]{newI, newJ});
                        }
                    }
                }
            }
        }
        return distance[nRows - 1][nCols - 1];
    }
}