class Solution {
    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() == 0 || s.length() == 1)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    if (j - i >= max && dp[i][j]) {
                        max = j - i;
                        res = s.substring(i, j + 1);
                    }
                    continue;
                }
                if (i == j - 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (j - i >= max && dp[i][j]) {
                            max = j - i;
                            res = s.substring(i, j + 1);
                        }
                    }
                    continue;
                }
                // aabbcc,
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i >= max && dp[i][j]) {
                        max = j - i;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}