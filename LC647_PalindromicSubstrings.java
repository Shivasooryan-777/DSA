public class LC647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes (single-character center)
            totalCount += expandAroundCenter(s, i, i);
            // Even-length palindromes (two-character center)
            totalCount += expandAroundCenter(s, i, i + 1);
        }

        return totalCount;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
