class Solution {
    public boolean isMatch(String s, String p) {
         int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // empty string matches empty pattern

        // Handle patterns like a*, a*b*, a*b*c* at the start
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    // Current characters match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char pre = p.charAt(j - 2); // character before *
                    // 0 occurrence OR at least 1 occurrence if matches
                    dp[i][j] = dp[i][j - 2] || 
                               ((pre == sc || pre == '.') && dp[i - 1][j]);
                }
            }
        }

        return dp[m][n]; 
    }
}