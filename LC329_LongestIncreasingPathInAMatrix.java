public class LC329_LongestIncreasingPathInAMatrix {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, memo, i, j));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int[][] memo, int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int longest = 1;

        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                    && matrix[nr][nc] > matrix[r][c]) {
                longest = Math.max(longest, 1 + dfs(matrix, memo, nr, nc));
            }
        }

        memo[r][c] = longest;
        return longest;
    }
}
