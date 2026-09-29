class Solution {
    int m, n;
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 != 0) return false;
        dp = new Boolean[m][n][m + n];
        return solve(grid, 0, 0, 0);
    }
    boolean solve(char[][] grid, int i, int j, int balance) {
        if (grid[i][j] == '(') balance++;
        else balance--;
        if (balance < 0) return false;
        if (i == m - 1 && j == n - 1) return balance == 0;
        if (dp[i][j][balance] != null) return dp[i][j][balance];
        boolean ans = false;
        if (i + 1 < m)  ans = solve(grid, i + 1, j, balance);
        if (!ans && j + 1 < n) ans = solve(grid, i, j + 1, balance);
        return dp[i][j][balance] = ans;   
    }
}