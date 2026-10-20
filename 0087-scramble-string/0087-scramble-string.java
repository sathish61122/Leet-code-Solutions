class Solution {
    private Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        memo = new Boolean[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(String s1, String s2, int i, int j, int len) {
        if (s1.regionMatches(i, s2, j, len)) {
            return true;
        }

        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }

        int[] freq = new int[26];

        for (int k = 0; k < len; k++) {
            freq[s1.charAt(i + k) - 'a']++;
            freq[s2.charAt(j + k) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                memo[i][j][len] = false;
                return false;
            }
        }

        for (int k = 1; k < len; k++) {
            // Without swapping
            if (solve(s1, s2, i, j, k) &&
                solve(s1, s2, i + k, j + k, len - k)) {
                memo[i][j][len] = true;
                return true;
            }

            // With swapping
            if (solve(s1, s2, i, j + len - k, k) &&
                solve(s1, s2, i + k, j, len - k)) {
                memo[i][j][len] = true;
                return true;
            }
        }

        memo[i][j][len] = false;
        return false;
    }
}