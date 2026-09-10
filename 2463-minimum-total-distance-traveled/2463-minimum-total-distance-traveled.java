class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        java.util.List<Integer> robots = new java.util.ArrayList<>(robot);
        java.util.Collections.sort(robots);
        java.util.Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        int n = robots.size();
        int m = factory.length;
        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][m + 1];
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 1; i <= n; i++) dp[i][0] = INF;
        for (int j = 1; j <= m; j++) {
            int factoryPos = factory[j - 1][0];
            int limit = factory[j - 1][1];
            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];
                long cost = 0;
                for (int k = 1; k <= Math.min(limit, i); k++) {
                    cost += Math.abs(robots.get(i - k) - factoryPos);
                    if (dp[i - k][j - 1] < INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + cost);
                    }
                }
            }
        } return dp[n][m];
    }
}