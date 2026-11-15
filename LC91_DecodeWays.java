public class LC91_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            int singleDigit = s.charAt(i) - '0';
            int twoDigits = (s.charAt(i - 1) - '0') * 10 + singleDigit;

            if (singleDigit != 0) {
                current += prev1;
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
