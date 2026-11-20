public class LC72_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        // Base case: converting empty word1 to word2 of length j requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0]; // Represents dp[i-1][j-1]
            dp[0] = i; // Base case: converting word1 of length i to empty word2 requires i deletions

            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Save dp[i-1][j] for next iteration's prev

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    // 1 + min(replace: prev, delete: dp[j], insert: dp[j-1])
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }

                prev = temp;
            }
        }

        return dp[n];
    }
}
