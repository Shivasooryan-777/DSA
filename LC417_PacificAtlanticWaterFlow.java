import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC417_PacificAtlanticWaterFlow {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Vertical borders: left column (Pacific), right column (Atlantic)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }

        // Horizontal borders: top row (Pacific), bottom row (Atlantic)
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }

        // Cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int r, int c) {
        reachable[r][c] = true;

        for (int[] dir : DIRECTIONS) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            // Water can flow from neighbor to current cell if neighbor height >= current cell height
            if (newR >= 0 && newR < heights.length && newC >= 0 && newC < heights[0].length
                    && !reachable[newR][newC] && heights[newR][newC] >= heights[r][c]) {
                dfs(heights, reachable, newR, newC);
            }
        }
    }
}

