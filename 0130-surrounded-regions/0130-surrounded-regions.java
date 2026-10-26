class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Check first and last columns
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // Check first and last rows
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // Capture surrounded regions and restore safe regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n
                || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        dfs(board, i - 1, j); // Up
        dfs(board, i + 1, j); // Down
        dfs(board, i, j - 1); // Left
        dfs(board, i, j + 1); // Right
    }
}